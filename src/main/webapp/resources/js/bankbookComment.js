const btn = document.querySelector('#btn');
const writer = document.querySelector('#writer');
const contents = document.querySelector('#contents');
const regDate = document.querySelector('#regDate')
const commentList = document.querySelector('#commentList');
const more = document.querySelector('#more');


//page 번호 담는 변수
let page=1;
//bookNum을 담는 변수
const bookNum = btn.getAttribute('data-booknum');
getCommentList(page, bookNum); //로딩이 시작한 다음에 바로 실행


btn.addEventListener('click', function(){
    // console.log(writer.value);
    // console.log(contents.value);
    // console.log(btn.getAttribute('data-booknum'));

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

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result); // 1 or {"success":"1"}

            // JSON 형식의 문자열을 JSON 객체로 변환
            result = JSON.parse(result); 
            console.log(result.success); //1

            writer.value="";
            contents.value="";

            if(result.success==1){
                alert('댓글 등록 완료');

                //안에 있는 데이터 다 지우고 다시 출력
                for(let i=0;i<commentList.children.length;){
                    commentList.children[0].remove();
                }
                page=1;
                getCommentList(page, bookNum);
            }
        }
    }
})



function getCommentList(p, bn) {
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 준비
    xhttp.open('GET', 'commentList.iu?page='+p+'&bookNum='+bn);

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
            let result = JSON.parse(xhttp.responseText.trim());
            console.log(result); //[{}, {}, ...]
            
            //<table class="table table-striped"></table>
            // let result = document.createElement('table');
            // let resultAttr = document.createAttribute('class');
            // resultAttr.value = 'table';
            // result.setAttributeNode(resultAttr);

            let pager = result.pager; //commentPager
            let ar = result.list; //댓글리스트

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

                td = document.createElement('td')
                let tdAttr = document.createAttribute('class');
                tdAttr.value='update';
                tx = document.createTextNode('수정');
                td.appendChild(tx);
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                td = document.createElement('td')
                tdAttr = document.createAttribute('class');
                tdAttr.value='delete';
                tx = document.createTextNode('삭제');
                td.appendChild(tx);
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                tdAttr = document.createAttribute('data-comment-num');
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                commentList.append(tr);

                if(page >= pager.totalPage){
                    more.classList.add('disabled');
                }else {
                    more.classList.remove('disabled');
                }
            }

        }
    })
}

// JSON
// DTO == {}
// num=1 == {"num":1, "bookNum":123, "writer":"name"}
// [{"num":1, "bookNum":123, "writer":"name"}, {"num":2, "bookNum":123, "writer":"name"}, {"num":3, "bookNum":123, "writer":"name"}]



//더보기
more.onclick=function(){
    page++;
    console.log(page);
    console.log(bookNum);
    getCommentList(page,bookNum);
}


//댓글 삭제/ 수정
commentList.addEventListener('click', function(event){
    
    console.log(event.target); //실제 클릭한 영역
    
    //댓글 삭제
    if(event.target.className=='delete'){
        let check = window.confirm('삭제하겠습니까?');

        if(check) {
            let num=event.target.getAttribute('data-comment-num');

            //1. XMLHTTPRequest 생성
            const xhttp = new XMLHttpRequest();

            //2. Method, URL 준비
            xhttp.open('POST','commentDelete.iu')
                   
            //3.Enctype(POST일 경우만 header 정보 요청)
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            //4. 요청 전송(POST일 경우 파라미터 추가)
            xhttp.send('num='+num);

            //5. 응답 처리
            xhttp.onreadystatechange=function(){
                if(this.status==200&&this.readyState==4){
                    let result = xhttp.responseText.trim(); //1
                    
                    //안에 있는 데이터 다 지우고 다시 출력
                    for(let i=0;i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                    page=1;
                    getCommentList(page, bookNum);
                }
            }
        }
    }

    //댓글 수정
    if(event.target.className=='update'){
        //1)
        // let contents = event.target.previousSibling.previousSibling.previousSibling;
        // console.log(contents);
        // let v = contents.innerHTML; 
        // contents.innerHTML="<textarea>"+v+"</textarea>"

        //2)모달창
        document.querySelector('#up').click();
    }

})
