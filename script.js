function toggleDropdown() {
    var dropdown = document.getElementsByClassName("dropdown-content")[0];
    var ex4 = document.getElementById("ex4");
    if (dropdown.style.display === "none" || dropdown.style.display === "") {
        dropdown.style.display = "flex";
        dropdown.style.flexDirection = "column";
        dropdown.style.gap = "6px";

        ex4.style.borderBottom = "solid";
        ex4.style.borderWidth = "5px";
        ex4.style.borderBottomColor = "black";

    } else {
        dropdown.style.display = "none";
        ex4.style.borderBottom = "None";
    }
}


