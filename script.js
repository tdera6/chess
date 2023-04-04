"use strict";

const tiles = document.querySelectorAll(".tile");

let i = 0;
tiles.forEach((e) => {
  e.innerHTML = i;
  i++;
  e.addEventListener("click", () => {
    console.log(e.dataset.column, e.dataset.row);
  });
});
