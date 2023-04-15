"use strict";

const tiles = document.querySelectorAll(".tile");

let gameState = [
  ["r", "n", "b", "q", "k", "b", "n", "r"],
  ["p", "p", "p", "p", "p", "p", "p", "p"],
  ["", "", "", "", "", "", "", ""],
  ["", "", "", "", "", "", "", ""],
  ["", "", "", "", "", "", "", ""],
  ["", "", "", "", "", "", "", ""],
  ["P", "P", "P", "P", "P", "P", "P", "P"],
  ["R", "N", "B", "Q", "K", "B", "N", "R"],
];

let clickedPiece = "";
let clickedTile = "";

// Displaying pieces

gameState.forEach((row, i) => {
  row.forEach((tile, j) => {
    if (tile !== "") tiles[i * 8 + j].classList.add("piece");
    if (tile === "P") tiles[i * 8 + j].classList.add("white-pawn");
    else if (tile === "R") tiles[i * 8 + j].classList.add("white-rook");
    else if (tile === "N") tiles[i * 8 + j].classList.add("white-knight");
    else if (tile === "B") tiles[i * 8 + j].classList.add("white-bishop");
    else if (tile === "Q") tiles[i * 8 + j].classList.add("white-queen");
    else if (tile === "K") tiles[i * 8 + j].classList.add("white-king");
    else if (tile === "p") tiles[i * 8 + j].classList.add("black-pawn");
    else if (tile === "r") tiles[i * 8 + j].classList.add("black-rook");
    else if (tile === "n") tiles[i * 8 + j].classList.add("black-knight");
    else if (tile === "b") tiles[i * 8 + j].classList.add("black-bishop");
    else if (tile === "q") tiles[i * 8 + j].classList.add("black-queen");
    else if (tile === "k") tiles[i * 8 + j].classList.add("black-king");
  });
});

function whitePawnMove(e, i) {
  if (!whitePawnLegalMoves(clickedTile, i)) return false;
  tiles[clickedTile].classList.remove("white-pawn");
  gameState[Math.floor(clickedTile / 8)][clickedTile % 8] = "";
  gameState[Math.floor(i / 8)][i % 8] = "P";
  e.classList.add("white-pawn");
}

function blackPawnMove(e, i) {
  if (!blackPawnLegalMoves(clickedTile, i)) return false;
  tiles[clickedTile].classList.remove("black-pawn");
  gameState[Math.floor(clickedTile / 8)][clickedTile % 8] = "";
  gameState[Math.floor(i / 8)][i % 8] = "p";
  e.classList.add("black-pawn");
}

function blackPawnLegalMoves(clickedTile, i) {
  if (blackPawnFirstMove(clickedTile, i)) return true;
  if (i === clickedTile + 8) return true;
}

function whitePawnLegalMoves(clickedTile, i) {
  if (whitePawnFirstMove(clickedTile, i)) return true;
  if (i === clickedTile - 8) return true;
}

function whitePawnFirstMove(clickedTile, i) {
  if (clickedTile >= 48 && clickedTile <= 56 && i === clickedTile - 16)
    return true;
}

function blackPawnFirstMove(clickedTile, i) {
  if (clickedTile >= 8 && clickedTile <= 16 && i === clickedTile + 16)
    return true;
}

tiles.forEach((e, i) => {
  e.addEventListener("click", () => {
    if (clickedPiece === "") {
      clickedPiece = gameState[Math.floor(i / 8)][i % 8];
      clickedTile = i;
    } else if (clickedPiece === "P") {
      whitePawnMove(e, i);
      clickedPiece = "";
      clickedTile = "";
    } else if (clickedPiece === "p") {
      blackPawnMove(e, i);
      clickedPiece = "";
      clickedTile = "";
    }
  });
});
