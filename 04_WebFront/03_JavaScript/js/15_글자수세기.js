const count = document.getElementById("count");
const content = document.getElementById("content");


content.addEventListener("input", e => {
    // input 이벤트 : 입력과 관련된 모든 행동
    //   input, textarea 등 입력 가능한 요소에 값이 입력되면 인식 key
    //   단점, 무엇이 입력되는지 알 수가 없다.
    count.innerText = e.target.value.length;

    if(e.target.value.length>100){
        count.classList.add("error");
    } else{
        count.classList.remove("error");
    }

    // 요소.classList.toggle('클래스명')
    // - 요소에 클래스가 없으면 추가 (true 반환)
    // - 요소에 클래스가 없으면 제거 (false 반환)
});