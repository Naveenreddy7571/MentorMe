document.addEventListener('DOMContentLoaded', function () {
    var section1 = document.querySelector('.section1');
    var imageCardContainer = document.querySelector('.image-card').parentElement; // Get the parent container of the image card

    window.addEventListener('scroll', function () {
        var scrollPosition = window.scrollY;
        var section1Bottom = section1.offsetTop + section1.offsetHeight;

        if (scrollPosition > section1Bottom) {
            imageCardContainer.classList.add('show-image-card');
        } else {
            imageCardContainer.classList.remove('show-image-card');
        }
    });
});




document.addEventListener("DOMContentLoaded", function() {
    var section4 = document.getElementById("section4");
    var section4Cards = document.querySelectorAll(".section4-card");

    function isInViewport(element) {
        var rect = element.getBoundingClientRect();
        return (
            rect.top >= 0 &&
            rect.left >= 0 &&
            rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
            rect.right <= (window.innerWidth || document.documentElement.clientWidth)
        );
    }

    function animateSection4() {
        section4Cards.forEach(function(card) {
            if (isInViewport(card)) {
                card.classList.add("animated");
            } else {
                card.classList.remove("animated");
            }
        });
    }

    // Detect scroll events and check if section 4 is in viewport
    window.addEventListener("scroll", animateSection4);
    window.addEventListener("resize", animateSection4);
    animateSection4(); // Call initially to check if section 4 is already in view
});