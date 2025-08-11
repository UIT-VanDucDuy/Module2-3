document.addEventListener("DOMContentLoaded", function () {
    const videoItems = document.querySelectorAll(".video-item");
    const mainVideo = document.querySelector(".main-video");

    videoItems.forEach(item => {
        item.addEventListener("click", () => {
            const videoUrl = item.getAttribute("data-video");
            if (mainVideo && videoUrl) {
                mainVideo.src = videoUrl;
            }
        });
    });
});
