const d1 = document.querySelector('#d1');
const text = document.querySelector('#text');
const result = document.querySelector('#result');

d1.addEventListener('click', function(){
    console.log('클릭클릭')

    //1. ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    //2. 요청 정보
    xhttp.open('GET', 'https://jsonplaceholder.typicode.com/posts/'+text.value);

    //3. 요청 발생
    xhttp.send();

    //4. 응답 결과 처리
    xhttp.onreadystatechange = function(){
        //this는 xhttp객체
        // console.log(this.status);
        // console.log(this.readyState);
        // console.log('------------------------');        
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText);

            let response = this.responseText.trim(); //앞뒤공백제거
            response = JSON.parse(response); //문자열을 객체로 바꿔줌

            let h3  = document.createElement('h3');
            let t = document.createTextNode(response.userId);
            h3.appendChild(t);
            result.append(h3);

            h3  = document.createElement('h3');
            t = document.createTextNode(response.id);
            h3.appendChild(t);
            result.append(h3);
            
            h3  = document.createElement('h3');
            t = document.createTextNode(response.title);
            h3.appendChild(t);
            result.append(h3);

            h3  = document.createElement('h3');
            t = document.createTextNode(response.body);
            h3.appendChild(t);
            result.append(h3);
                       
        }
    }

    console.log('Ajax 발생');

})