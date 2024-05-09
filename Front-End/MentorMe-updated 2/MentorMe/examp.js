let but = document.querySelector(".login")
let form = document.querySelector("form")
but.addEventListener("click", (e) => {
    e.preventDefault();
    let email = form[0].value;
    console.log(email)
    let password = form[1].value;
    console.log(password);
    form.action = 'Homepage.html';
    form.submit();
});
