// const d2 = document.getElementById('d2');
const d2 = document.querySelector('#d2');
const d1 = document.querySelector('#d1');
const d3 = document.querySelector('#d3');
const d4 = document.querySelector('#d4');

d2.addEventListener('mouseenter', function(){
    console.log('Enter');
    console.log(d1.class); //예약어라서 안됨
    console.log(d1.getAttribute('class'));
    // d1.className='c2';
    d1.classList.replace('c3', 'c2'); //여러개중 하나 변경
})

d2.addEventListener('mouseleave', function(){
    console.log('Leave');
    console.log(d1.className);
    console.log(d1.classList);
    d1.classList.add('c4'); //class추가
})

d3.addEventListener('click', function(){
    console.log('클릭클릭')
    d2.classList.toggle('c2');
    console.log(d2.classList.contains('c2')); //원하는 클래스 이름이 있는지
})

d4.addEventListener('click', function(){
    console.log("origin : ",location.origin); //URL
    console.log("hostname : ",location.hostname); //IP
    console.log("pathname : ",location.pathname); //경로
    console.log("search : ",location.search); //?a=10
    // location.href='./dom_9.html?a=10';

})