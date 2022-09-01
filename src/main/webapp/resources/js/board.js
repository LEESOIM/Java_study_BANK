//list.jsp
//let kind = '${param.kind}'; 자바스크립트에서 EL은 문자로 인식한다
//alert(kind);


//add.jsp
const addFiles = document.getElementById('addFiles');
const fileAdd = document.getElementById('fileAdd');

let count=0;
let idx=0;

fileAdd.addEventListener('click', function(){   
//<div class="mb-3" id="file0">
//  <label class="form-control-sm">File</label>
//  <input type="file" name="files" class="form-control">
//  <button type="button" class="del">삭제</button>
//</div>

    if(count>4) {
        alert('파일 첨부 5개 가능');
        return;
    }

    //부모 Element div 생성
    let div = document.createElement('div');
    let divAtt = document.createAttribute('class')
    divAtt.value='mb-3';
    div.setAttributeNode(divAtt);
    divAtt = document.createAttribute('id');
    divAtt.value='file'+idx;
    div.setAttributeNode(divAtt);


    //자식 Element label 생성
    let la = document.createElement('label'); //<label></label>
    let t = document.createTextNode('File'); //File
    la.appendChild(t); //<label>File</label>
    let laAtt = document.createAttribute('class'); //class=""
    laAtt.value='form-control-sm'; //class="form-control-sm"
    la.setAttributeNode(laAtt); //<label class="form-label">File</label>
    div.appendChild(la);
    

    //자식 Element input 생성
    let inp = document.createElement('input');
    let att = document.createAttribute('type');
    att.value='file';
    inp.setAttributeNode(att); //type="file"
    att = document.createAttribute('name');
    att.value='files';
    inp.setAttributeNode(att); //name="files"
    att = document.createAttribute('class');
    att.value='form-control';
    inp.setAttributeNode(att); //class="form-control"
    div.appendChild(inp);

    //자식 Element button 생성
    let btn = document.createElement('button');
    let btncon = document.createTextNode('삭제');
    btn.appendChild(btncon); //<button>삭제</button>
    let btnatt = document.createAttribute('type');
    btnatt.value='button';
    btn.setAttributeNode(btnatt); //type="button"
    btnatt = document.createAttribute('class');
    btnatt.value='del btn btn-outline-danger btn-sm';
    btn.setAttributeNode(btnatt); //class="del"
    btnatt = document.createAttribute('title');
    btnatt.value = idx;
    btn.setAttributeNode(btnatt);
    div.appendChild(btn);

    addFiles.append(div);   
    count++;
    idx++;
})


addFiles.addEventListener('click', function(event){
    if(event.target.className='del'){
        const idxNum = document.getElementById('file'+event.target.title);
        idxNum.remove();
        count--;
    }
})