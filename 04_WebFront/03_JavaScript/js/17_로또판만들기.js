const createBtn = document.getElementById("createBtn");
const lottoBoard = document.getElementById("lottoBoard");

createBtn.addEventListener("click", () => {
    lottoBoard.innerHTML = ""; // 이전에 생성된 내용을 모두 삭제
                                // 클릭할 때 마다 계속 번호가 생성되는걸 방지
    for(let i=1;i<=45;i++){
        const child = document.createElement("div");
        child.classList.add("number");
        child.innerText = i;

        child.addEventListener("click", e =>{
            if(e.target.classList.contains("active")){
                e.target.classList.toggle("active");
            } else{
                // active 클래스를 가진 요소가 6개 이상인 경우
                if(document.getElementsByClassName("active").length >= 6){
                    alert("6개까지만 선택할 수 있습니다.")
                    return;
                }
                e.target.classList.toggle("active");
            }
        });
        lottoBoard.append(child);
    }
});




