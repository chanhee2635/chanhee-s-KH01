const apply = document.getElementById("apply");
const registration = document.getElementById("registration");
const content = document.getElementById("content");
const size = document.getElementById("size");
const color = document.getElementById("color");
const result = document.getElementById("result");

apply.addEventListener("click", () => {
    content.style.color = color.value;
    content.style.fontSize = size.value + "px";
});

registration.addEventListener("click", () => {

    const child = document.createElement("div");

    child.innerText = content.value;
    child.setAttribute("style", content.getAttribute("style"));

    result.append(child);
});