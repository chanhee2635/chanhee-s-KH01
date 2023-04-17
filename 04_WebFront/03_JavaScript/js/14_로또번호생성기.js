document.getElementById("createBtn").addEventListener("click", () => {
    const arr = [];

    while(arr.length < 6){ // arr에 저장된 값이 6개 미만인 경우 반복
        const random = Math.floor(Math.random() * 45+1);

        if(arr.indexOf(random) == -1){
            arr.push(random); // 배열 마지막 요소로 추가
        }
    }
    
    arr.sort((a, b) => a - b);

    const clist = document.getElementById("container").children;
    for(let i=0;i<clist.length;i++){
        
        clist[i].innerHTML = arr[i];
        clist[i].id = 'div' + i;
        if(clist[i].innerHTML <= 10){
            document.getElementById("div" + i).style.backgroundColor = "rgb(242, 206, 0)";
        } else if(clist[i].innerHTML <= 20){
            document.getElementById("div" + i).style.backgroundColor = "dodgerblue";
        } else if(clist[i].innerHTML <= 30){
            document.getElementById("div" + i).style.backgroundColor = "rgb(233, 102, 78)";
        } else if(clist[i].innerHTML <= 40){
            document.getElementById("div" + i).style.backgroundColor = "gray";
        } else {
            document.getElementById("div" + i).style.backgroundColor = "rgb(122, 215, 122)";
        }
    }

});