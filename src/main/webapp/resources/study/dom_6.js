//Button에 click EVENT 등록
const d1 = document.getElementById('d1'); //div
const btn = document.getElementById('btn');
const list = document.getElementById('list'); //ul
const add = document.getElementById('add');
const list2 = document.getElementById('list2'); //ol
const add2 = document.getElementById('add2');
const d2 = document.getElementById('d2');
const add3 = document.getElementById('add3');
const d3 = document.getElementById('d3');
const add4 = document.getElementById('add4');
const add5 = document.getElementById('add5');

btn.addEventListener('click', function(){
    d1.innerHTML='<img src="/resources/images/zzang9.png">';
})

add.addEventListener('click', function(){
    let li = document.createElement('li'); //<li></li>
    let t = document.createTextNode('test'); //test
    li.appendChild(t);                    //<li>test</li>
    list.append(li); //밑에 추가
})

add2.addEventListener('click', function(){
    let h = document.createElement('h3'); //<h3></h3>
    let t = document.createTextNode('Hello'); //Hello
    h.appendChild(t); //<h3>Hello</h3>
    let li = document.createElement('li'); //<li></li>
    li.appendChild(h); // <li><h3>Hello</h3></li>
    list2.prepend(li); //위에 추가
})

//add3을 클릭하면 div#d2 내에 input Element를 Append
add3.addEventListener('click', function(){
    let inp = document.createElement('input'); //<input>
    let ty = document.createAttribute('type'); //type=
    ty.value='checkbox';                       //type='checkbox'
    inp.setAttributeNode(ty);               //<input type='checkbox'> 
    d2.appendChild(inp);
})

add4.addEventListener('click', function(){
    let h = document.createElement('h3'); //<h3></h3>
    let t = document.createTextNode('Before'); //<h3>Before</h3>
    h.appendChild(t);
    d3.before(h);
})

add5.addEventListener('click', function(){
    let h = document.createElement('h3');
    let t = document.createTextNode('After');
    h.appendChild(t);
    d3.after(h);
})