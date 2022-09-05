//const d1 = document.getElementById('d1');
const d1 = document.querySelector('#d1');
const d1_2_1_2 = document.querySelector('#d1_2_1_2');
const btn = document.querySelector('#btn');

//상대선택자
//child 나를 기준 직계 자식들(배열)
console.log(d1.childNodes); //공백까지 가져온다
console.log(d1.childNodes[3]);
console.log(d1.childNodes[3].childNodes[1]);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);

console.log(d1.children); //공백제외
console.log(d1.children[1].children[0].children[0].innerHTML);

//li 모두 삭제
d1.addEventListener('click', function(){
    let li = d1.children[1].children[0].children;
    console.log(li);

    for(let i=0;i<li.length;) {
        li[i].remove();
    }
    console.log(li);
})

console.log('-----------------------------------');


//parent 부모는 하나 (배열X)
console.log(d1_2_1_2.parentNode); //<ul id="d1_2_1">
console.log(d1_2_1_2.parentNode.parentNode); //<div id="d1_2">
console.log(d1_2_1_2.parentNode.parentNode.parentNode); //<div id="d1">

btn.addEventListener('click', function(){
    d1_2_1_2.parentNode.parentNode.remove();
    console.log(d1_2_1_2.parentNode.parentNode);
})

//나를 기준 왼쪽
console.log(d1_2_1_2.previousSibling.previousSibling);
//나를 기준 오른쪽
console.log(d1_2_1_2.nextSibling.nextSibling);