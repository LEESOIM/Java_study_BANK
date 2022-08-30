alert("Welcome");

//1
//int num=1; java
var num=1;
//num='abc';
let num2='1';

console.log(num==num2); //값만
console.log(num===num2); //타입까지봄

for(let i=0;i<10;i++) {
    console.log(i);
    var count=2;
}

console.log('------------')
//console.log(i);
console.log(count);  //var : 지역변수, 전역변수 문제가 발생할 여지가 있음
console.log('------------')

let ar = [1, '2', 3.12, true];
console.log(ar[0]);
console.log(ar[1]);
console.log(ar[2]);
console.log(ar[3]);
console.log('------------')

let ar2 = ['4', 1, 3, '2'];

ar2.push(5); //끝에넣기
console.log(ar2);

ar2.unshift('9'); //앞에넣기
console.log(ar2);

ar2.sort();
console.log(ar2); //오름차순

ar2.reverse(); //순서 변경
console.log(ar2); 

ar2.forEach(function(v, i, ar2) { //반복문for문
    console.log("v : ",v); //"v : "+v
    console.log("i : ",i);
    console.log('------------');
});