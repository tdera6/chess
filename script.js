"use strict";

const tiles = document.querySelectorAll(".tile");

tiles.forEach((e) => {
  e.addEventListener("click", () => {
    console.log(e.dataset.column, e.dataset.row);
  });
});
