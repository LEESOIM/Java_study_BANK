
//1. 선택자
const d1 = window.document.getElementById('d1');
const d2 = document.getElementById('d2');
const d3 = document.getElementById('d3');
const year = document.getElementById('year');
const month = document.getElementById('month');
const date = document.getElementById('date');
const d4 = document.getElementById('d4');

//alert(d1.value);
alert(d1.getAttribute('value'));

//d2.type="button";
d2.setAttribute("type","button");


let count = window.prompt("숫자를 입력하세요");
let t = "";
for(let i=0;i<count;i++) {
    t=t+'<input type="text">';
}
d3.innerHTML=t;

//-----------------------------------------
let y = "";
for(let i=1950;i<2023;i++){
    y=y+'<option>'+i+'</option>';
}
year.innerHTML=y;

let m = "";
for(let i=1;i<13;i++){
    m=m+'<option>'+i+'</option>';
}
month.innerHTML=m;

let d = "";
for(let i=1;i<32;i++){
    d=d+'<option>'+i+'</option>';
}
date.innerHTML=d;
//-----------------------------------------

let r = prompt("ROW 갯수 입력");//3
let c = prompt("Column 갯수 입력");//2
let tr = "";
let td = "";

for(let i=0;i<r;i<++){
    tr=tr+'<tr>'+i+'<tr>';
}

for(let j=0;j<c;j++){
    td=td+'<td>'+j+'<td>';
}

d4.innerHTML=tr;
d4.innerHTML=td;