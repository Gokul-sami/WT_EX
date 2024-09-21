function toggleDropdown() {
    var dropdown = document.getElementsByClassName("dropdown-content")[0];
    if (dropdown.style.display === "none" || dropdown.style.display === "") {
        dropdown.style.display = "flex";
        dropdown.style.flexDirection = "column";
        dropdown.style.gap = "5px";
    } else {
        dropdown.style.display = "none";
    }
}


