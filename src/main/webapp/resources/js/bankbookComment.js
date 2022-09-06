let btn = document.querySelector('#btn');
let writer = document.querySelector('#writer');
let contents = document.querySelector('#contents');
let regDate = document.querySelector('#regDate')
let commentList = document.querySelector('#commentList');

getCommentList(); //로딩이 시작한 다음에 바로 실행

btn.addEventListener('click', function(){
    // console.log(writer.value);
    // console.log(contents.value);
    // console.log(btn.getAttribute('data-booknum'));

    let bookNum = btn.getAttribute('data-booknum');
    let wv = writer.value;
    let cv = contents.value;
    
    //-------------------- Ajax --------------------
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();
    
    //2. Method, URL 준비
    xhttp.open('POST','./commentAdd.iu');
    
    //3. Enctype(POST일 경우만)
    //요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 요청 발생(POST일 경우 파라미터 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5. 응답 처리 (이벤트4번 변할때마다 이벤트 출력)
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result); // 1 or {"success":"1"}

            // JSON 형식의 문자열을 JSON 객체로 변환
            result = JSON.parse(result); 
            console.log(result.success); //1
            if(result.success==1){
                alert('댓글 등록 완료');
                getCommentList();
            }
        }
    }
})


function getCommentList() {
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 준비
    xhttp.open('GET', 'commentList.iu?page=1&bookNum='+btn.getAttribute('data-booknum'));

    //3.Enctype(POST일 경우만)

    //4. 요청 전송(POST일 경우 파라미터 추가)
    xhttp.send();

    //5. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState==4 && xhttp.status==200) {
            
            console.log(xhttp.responseText); //테이블jsp형식 or 뭉탱이
            //1) jsp 사용한 결과물
//            commentList.innerHTML=xhttp.responseText.trim(); 


            //2) json 결과물
            //JSON 오브젝트 타입으로 바꿔줌
            let ar = JSON.parse(xhttp.responseText.trim());
            console.log(ar); //[{}, {}, ...]
            
            //<table class="table table-striped"></table>
            let result = document.createElement('table');
            let resultAttr = document.createAttribute('class');
            resultAttr.value = 'table';
            result.setAttributeNode(resultAttr);

            commentList.innerHTML="";
            for(let i=0;i<ar.length;i++){

                let tr = document.createElement('tr') //<tr></tr>

                let td = document.createElement('td') //<td></td>
                let tx = document.createTextNode(ar[i].contents);
                td.appendChild(tx);
                tr.appendChild(td);

                td = document.createElement('td')
                tx = document.createTextNode(ar[i].writer);
                td.appendChild(tx);
                tr.appendChild(td);

                td = document.createElement('td')
                tx = document.createTextNode(ar[i].regDate);
                td.appendChild(tx);
                tr.appendChild(td);
            
                result.appendChild(tr);
            }
            commentList.append(result);
        }
    })

}

// JSON
// DTO == {}
// num=1 == {"num":1, "bookNum":123, "writer":"name"}
// [{"num":1, "bookNum":123, "writer":"name"}, {"num":2, "bookNum":123, "writer":"name"}, {"num":3, "bookNum":123, "writer":"name"}]