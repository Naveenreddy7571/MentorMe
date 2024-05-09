// Profile menu javaScript
let ProfileMenuDiv = document.getElementById("profile_menu");
let arrow_drop_down_btn = document.getElementById("arrow_drop_down");

arrow_drop_down_btn.addEventListener("click", (e) => {
    e.stopPropagation();
    ProfileMenuDiv.classList.toggle("open-menu");
});

document.addEventListener("click", (event) => {
    if (!ProfileMenuDiv.contains(event.target) && event.target !== arrow_drop_down_btn) {
        ProfileMenuDiv.classList.remove("open-menu");
    }
});



// comments popup js code
let blur = document.getElementById("blur");
let commentBtnsList = document.querySelectorAll("#comment-btn")
for(commentBtn of commentBtnsList)
{
    commentBtn.addEventListener("click",()=>
        {
            commentWindowToggle();
        });
}

let commentCloseBtn = document.getElementById("comment-close-btn")
commentCloseBtn.addEventListener("click",()=>
{
    commentWindowToggle();
});

function commentWindowToggle() {
    blur.classList.toggle("activate-blur");
    let commentPopUpdiv = document.getElementById("comment-popup");
    commentPopUpdiv.classList.toggle("open-comment-popup");
}

// Like Button Js

let LikeBtnDivs = document.querySelectorAll(".like-button .heart-icon");

for (let LikeBtnDiv of LikeBtnDivs) {
    LikeBtnDiv.addEventListener("click", () => {
        
        let likeButton = LikeBtnDiv.closest(".like-button");
        let LikecountDiv = likeButton.querySelector(".likes-amount");
        
        LikeBtnDiv.classList.toggle("liked");
        let presentLikeCnt = Number(LikecountDiv.innerHTML);

        if (LikeBtnDiv.classList.contains("liked")) {
            presentLikeCnt += 1;
        } else {
            presentLikeCnt -= 1;
        }

        LikecountDiv.innerHTML = presentLikeCnt;
    });
}

// post options js

let postOptionDiv = document.querySelector(".post-options-div");
let postOptionBtn = document.querySelector("#post-options-btn");

postOptionBtn.addEventListener("click", (event) => {
    event.stopPropagation(); 
    postOptionDiv.classList.toggle("active");
});

document.addEventListener("click", (event) => {
    if (!postOptionDiv.contains(event.target) && event.target !== postOptionBtn) {
        postOptionDiv.classList.remove("active");
    }
});
