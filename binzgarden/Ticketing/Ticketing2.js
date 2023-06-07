const btn1 = document.
function plus(cnt){
    if(cnt.innerText>8){
        return;
    }
    cnt.innerText++; 
}
function minus(cnt){
    if(cnt.innerText<1){
        return;
    }
    cnt.innerText--; 
}