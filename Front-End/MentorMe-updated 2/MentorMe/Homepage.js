let likecomment = document.querySelector(".likecomment");
console.dir(likecomment)
let likebtn = likecomment.childNodes[1];

likebtn.addEventListener('click', (event) => {
    likebtn.style.backgroundColor = "red"; 
});
