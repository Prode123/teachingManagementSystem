// 李昊润负责部分：个人信息，修改头像，修改密码

(function () {
  // 直接从localStorage里拿个人信息
  let userInfo = localStorage.getItem('profile');
  console.log(JSON.parse(userInfo));
  const oImg = document.querySelector('.user-img img');
  var oInfo = document.querySelector('.profile-info');
  // var userId = userInfo.data.data.number;
  // 通过id获取个人信息
  request.get('/manangmentSystem/user/getUser?number=001').then((res) => {
    console.log('个人信息', res);
    // let info = {
    //   username: res.data.data.username,
    //   sex: res.data.data.sex,
    //   identityCard: res.data.data.identityCard,
    //   uid: res.data.data.uid,
    //   teachingResearch: res.data.data.teachingResearch,
    //   faculty: res.data.data.faculty,
    //   phoneNumber: res.data.data.phoneNumber,
    // };
    let info = {
      "code": 200,
      "msg": "OK",
      "data": {
        "uid": 1,
        "username": "程世玉",
        "roleId": "0",
        "passwd": "$2a$10$m7bbnia1Xq/oXW5BbSgJ6esdmOEMNVquyVHb5/uQYEgZNodqXqdG2",
        "number": "001",
        "identityCard": "41011197910220043",
        "phoneNumber": "13674971648",
        "status": 0,
        "createTime": null,
        "modifiedTime": null,
        "sex": 0,
        "clazz": "计科三班",
        "faculty": "河南财政金融学院",
        "title": "",
        "grade": "2019",
        "major": "计算机科学与技术",
        "level": 1,
        "teachingResearch": null
      }
    }
    let teainfo = info.data;
    // console.log()
    let html = template('teaInfo', teainfo);
    oInfo.innerHTML = html;
    let userImg = document.querySelector('.user-img ul');
    let username = userImg.querySelector('li');
    username.innerHTML = teainfo.username;
  });

  // 动态获取奖项类别的位置，
  var awadeInfoBtn = document.querySelector('#awade-type-info');
  var awadeInfo = document.querySelector('.awade-type-details');
  awadeInfoBtn.onclick = function (ev) {
    awadeInfo.style.display = 'block';
    var oEvent = ev || window.event;
    oEvent.cancelBubble = true;
    // var pos = posi(oEvent);
    awadeInfo.style.top = oEvent.clientY - awadeInfo.offsetHeight + 'px';
    awadeInfo.style.left = oEvent.clientX - awadeInfo.offsetWidth + 'px';
  };

  document.addEventListener('click',()=> {
    awadeInfo.style.display = 'none';
  });

  var close = document.querySelector(' .awade-type-details .close');
  close.onclick = function (ev) {
    var oEvent = ev || window.event;
    awadeInfo.style.display = 'none';
  };

  // 封装一个函数，跟随鼠标的层
  function posi(ev) {
    var scolltop = document.documentElement.scrollTop || document.body.scrollTop;
    var scollleft = document.documentElement.scrollLeft || document.body.scrollLeft;
    return {
      x: ev.clientX + scollleft,
      y: ev.clientY + scolltop,
    };
  }
  let userImgPath = '';
  const userImg = document.querySelector('.userImg');
  // 获取用户图像
  request.get(`/manangmentSystem/user/getHeadImage?uid=001`).then((res) => {
    // localStorage.getitem(profile).date.date.number
    console.log('用户图像', res);
    const { path } = res.data.data.path;
    userImgPath = path;
    console.log(path);
    userImg.setAttribute('src', path);
  });

  // 修改密码是的默认头像
  let upImg = document.querySelector('#default-img');
  upImg.src = userImgPath;
  // 修改密码
  var aEye = document.querySelectorAll('.eye');
  var aType = document.querySelectorAll('.update-form input[type="password"]');
  // alert(aEye.length);
  for (var i = 0; i < aEye.length; i++) {
    var flag = 0;
    aEye[i].index = i;
    aEye[i].onclick = function () {
      if (flag == 0) {
        aType[this.index].type = 'text';
        // this.src = '../../../static/img/hide.svg';
        this.classList.remove('icon-yincangmima');
        this.classList.add('icon-mimaxianshi');
        // this.th:src = '@{/img/hide.svg'}';// 这个是不行的
        flag = 1;
      } else if (flag == 1) {
        aType[this.index].type = 'password';
        // this.src = '../../../static/img/show.svg';
        this.classList.remove('icon-mimaxianshi');
        this.classList.add('icon-yincangmima');
        flag = 0;
      }
    };
  }
  // console.log(aType.length);
  // 判断两次密码是否相等
  var pwdSubmit = document.querySelector('.info-btn input'); //input button
  pwdSubmit.addEventListener('click', () => {
    if (
      aType[1].value == aType[2].value &&
      aType[0].value !== '' &&
      aType[1].value !== '' &&
      aType[2].value !== ''
    ) {
      var flag = confirm('确定是否修改?');
      if (flag) {
        // 点击修改密码 发送请求
        request
          .request({
            url: '/manangmentSystem/user/updatePw', 
            params: {
              number: JSON.parse(localStorage.getItem('profile')).originalUserDB.number,
              newPasswd: aType[2].value,
              oldPasswd: aType[0].value,
            },
            method: 'PUT',
          })
          .then((res) => {
            // if(res.date.msg  == 'ok') {
            //   alert('密码修改成功');
            //   location.href = '../../../templates/index.html';
            // }
            console.log('修改密码', res);
            alert('密码修改成功,请重新登录');
            // location.href = '../../../templates/index.html';
            location.href = 'index.html';
          });
      }
    } else if (aType[1].value != aType[2].value) {
      alert('两次的密码不相等，请重新输入密码');
    } else if (aType[0].value == '' || aType[1].value == '' || aType[2].value == '') {
      alert('密码不能为空');
    }
  });

  // 点击图片修改头像
  let updateFlag = false;
  var fileBtn = document.querySelector('#fileBtn');
  fileBtn.onchange = function () {
    if (this.files.length) {
      var file = this.files[0];
      var reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = function () {
        var oImg = document.querySelector('.update-photo img');
        oImg.src = reader.result;
        updateFlag = true;
      };
    }
  };

  // 在修改头像页面写，点击确定，弹是否确定修改，发送请求
  var updateImg = document.querySelector('.update-photo-btn'); //input button
  updateImg.addEventListener('click', () => {
    if (updateFlag) {
      var flag = confirm('确定是否修改?');
      if (flag) {
        let formData = new FormData();
        formData.append('file', fileBtn.files[0]);
        formData.append('uid', '001');
        request
          .request({
            method: 'POST',
            url: '/manangmentSystem/user/updateHeadImage',
            params: formData,
            headers: { 'Content-Type': 'multipart/form-data' },
          })
          .then((res) => {
            oImg.src = res.data.data.path;
            console.log(res);
          });
      }
    } else {
      alert('当前并未修改头像，请修改头像');
    }
  });

  // 奖项填报
  // 上传获奖图片
  const uploadFile = document.getElementById('uploadFile');
  const uploadPhotoInfo = document.querySelector('.file-lists');
  let file = new FormData();

  uploadFile.onchange = function () {
    let files = this.files;
    console.log(files.length, '//./././//./');
    for (let i = 0; i < files.length; i++) {
      if (!file.has(files[i].name) &&
        files[i].size < 1024 * 1024 * 2 &&
        (files[i].type == 'image/jpeg' ||
          files[i].type == 'image/png' ||
          files[i].type == 'image/gif' ||
          files[i].type == 'image/jpg')
      ) {
        // console.log(files[i]);
        var fileUl = document.createElement('div');
        uploadPhotoInfo.appendChild(fileUl);
        fileUl.classList.add('my-form');
        var fileSpan = document.createElement('span');
        var fileDelBtn = document.createElement('input');
        fileDelBtn.type = 'button';
        fileDelBtn.value = '删除';
        var fileViewBtn = document.createElement('input');
        fileViewBtn.type = 'button';
        fileViewBtn.value = '预览';
        fileViewBtn.classList.add('info-view');
        fileViewBtn.classList.add('info-oper');
        fileDelBtn.classList.add('info-del');
        fileDelBtn.classList.add('info-oper');
        fileUl.appendChild(fileSpan);
        fileUl.appendChild(fileDelBtn);
        fileUl.appendChild(fileViewBtn);
        fileSpan.classList.add('upload-filename');
        file.append(files[i].name, files[i]);
        console.log(file.get(files[i].name));
        console.log(files[i].name);
        fileSpan.innerHTML = files[i].name;
        // 点击删除之后会删掉该行
        // let infoDel = document.querySelectorAll('.info-del');
        // for (let i = 0; i < infoDel.length; i++) {
        fileDelBtn.name = files[i].name;
        fileDelBtn.onclick = function () {
          console.log(this.name);
          file.delete(this.name);
          uploadPhotoInfo.removeChild(this.parentNode);
          document.removeEventListener('click',showAlertDiv);
          // };
        };

        // 使用FileReader获取图片的路径
        for (let i = 0; i < files.length; i++) {
          // 创建一个层，用于显示预览的图片
          let viewDiv = document.createElement('div');
          fileUl.appendChild(viewDiv);
          viewDiv.classList.add('alert-photo-div');
          let viewPhoto = document.createElement('img');
          viewDiv.appendChild(viewPhoto);
          let viewSpan = document.createElement('span');
          viewDiv.appendChild(viewSpan);
          viewSpan.classList.add('iconfont');
          viewSpan.classList.add('icon-guanbi');
          viewSpan.classList.add('close');

          let reader = new FileReader();
          reader.onload = function (e) {
            let oEvent = e || window.event;
            let _src = oEvent.target.result;
            viewPhoto.setAttribute('src', _src);
          };
          reader.readAsDataURL(files[i]);
        }

        //点击预览后弹出一个层
        var infoView = document.querySelectorAll('.info-view');
        var viewImg = document.querySelectorAll('.alert-photo-div');
        // let j;
        let this_ = '';
        for (let j = 0; j < infoView.length; j++) {
          infoView[j].index = j;
          for (let k = 0; k < viewImg.length; k++) {
            viewImg[k].classList.remove('alert-show')
          }
          infoView[j].onclick = function (ev) {
            var oEvent = ev || window.event;
            oEvent.cancelBubble = true;
            this_ = viewImg[this.index];
            // this_.style.display = 'block';
            this_.classList.add('alert-show');
            console.log(this_);
            if(this_) {
              document.addEventListener('click',showAlertDiv);
            }
          };
          // document.onclick = function () {
          //   console.log(this_);
          //   this_.classList.remove('alert-show');
          // }
          console.log(this_);
          
          

          function showAlertDiv() {
              this_.classList.remove('alert-show');
              // showAlertDiv = null;
              // this_=null;
              document.removeEventListener('click',showAlertDiv);

            }
          // this_=null;
          // this_.classList.add();


        }


        // 点击X关闭弹出层
        let  _this;
        var close = document.querySelectorAll('.alert-photo-div .close');
        for (let i = 0; i < close.length; i++) {
          close[i].index = i;
          close[i].onclick = function (ev) {
            var oEvent = ev || window.event;
            _this = this.parentNode;
            this.parentNode.style.display = 'none';
            oEvent.cancelBubble = true;
          };
        }

        // document.addEventListener('click',()=> {
        //   // console.log(this_);
        //   _this.style.display = 'none';
        // })
      } else {
        alert('文件上传不符合规则');
      }
    }
  };
  //封装一个函数，用于检测单选框的value
  function checkRadioValue(name) {
    for (let i = 0; i < name.length; i++) {
      if (name[i].checked) {
        return name[i].value;
      }
    }
  }




  // let tname = document.querySelector('.tid');//指导老师名称
  

  // var teaLis = teaInfo.querySelectorAll('li');
  // console.log(teaLis.length);
  // for (var i = 0; i < teaLis.length; i++) {
  //   teaLis[i].onclick = function() {
  //     tname = this.children[0].innerHTML;
  //   }
  // }

  // // 点击旁白会关闭弹出层，点击内容区不会关闭
  // document.addEventListener('click',()=> {
  //   guideTea.style.display='none';
  // })
    // guideTeaSearch.addEventListener('click',function (ev) {
    //   guideTea.style.display='none';
    // });

  // 查询学生的人才培养方案
  request
    .request({
      method: 'GET',
      url: '/manangmentSystem/fileOperate/getStudentFile',
      params: {
        pageNum: 1,
        iconpageSize: 5,
        uid: '001',
      },
    })
    .then((res) => {
      console.log('人才培养方案', res);
    });

  // 单个文件详情
  request
    .request({
      method: 'GET',
      url: '/manangmentSystem/fileOperate/getOneFile',
      params: {
        did: 1,
      },
    })
    .then((res) => {
      console.log('单个文件详情', res);
    });


    // 查询多个文件
    request
    .get(
      '/manangmentSystem/fileOperate/getAllFiles?pageNum=%3CpageNum%3E&pageSize=%3CpageSize%3E&uid=%3Cuid%3E&condition=%3Ccondition%3E&fileType=%3CfileType%3E&major=%3Cmajor%3E&semester=%3Csemester%3E&fileName=%3CfileName%3E&category=%3Ccategory%3E&status=%3Cstatus%3E'
    )
    .then((res) => {
      console.log('查询多个文件', res);
      let teaClassDoc = document.querySelectorAll('.tea-class-tbody');
      // let list = res.data.list;
      // let teaClass = template('teaClassDoc', list);
      // for (let i = 0; i < teaClassDoc.length; i++) {
      //   teaClassDoc[i].innerHTML = teaClass;
      // }
      // teaClassDoc[0].innerHTML = teaClass;
      let result = {
            "code": 200,
            "msg": "OK",
            "data": {
                "total": 1,
                    "list": [{
                          "did": 2,
                          "path": "2",
                          "size": 2,
                          "fileName": 'Java面向对象设计',
                          "fileType": null,
                          "createTime": null,
                          "modifiedTime": null,
                          "grade": "2019",
                          "semester": "2",
                          "faculty": "计算机与信息技术学院",
                          "major": "计算机科学与技术",
                          "uid": 2,
                          "status": 2,
                          "reason": "2",
                          "auditId": null,
                          "course": "2",
                          "level": 1
                          },
                          {
                          "did": 2,
                          "path": "2",
                          "size": 2,
                          "fileName": 'Java面向对象设计',
                          "fileType": null,
                          "createTime": null,
                          "modifiedTime": null,
                          "grade": "2019",
                          "semester": "2",
                          "faculty": "计算机与信息技术学院",
                          "major": "计算机科学与技术",
                          "uid": 2,
                          "status": 0,
                          "reason": "2",
                          "auditId": null,
                          "course": "2",
                          "level": 0
                          },{
                            "did": 2,
                            "path": "2",
                            "size": 2,
                            "fileName": 'Java面向对象设计',
                            "fileType": null,
                            "createTime": null,
                            "modifiedTime": null,
                            "grade": "2019",
                            "semester": "2",
                            "faculty": "计算机与信息技术学院",
                            "major": "计算机科学与技术",
                            "uid": 2,
                            "status": 1,
                            "reason": "2",
                            "auditId": null,
                            "course": "2",
                            "level": 1
                            },{
                              "did": 2,
                              "path": "2",
                              "size": 2,
                              "fileName": 'Java面向对象设计',
                              "fileType": null,
                              "createTime": null,
                              "modifiedTime": null,
                              "grade": "2019",
                              "semester": "2",
                              "faculty": "计算机与信息技术学院",
                              "major": "计算机科学与技术",
                              "uid": 2,
                              "status": 0,
                              "reason": "2",
                              "auditId": null,
                              "course": "2",
                              "level": 1
                              }],
                "pageNum": 1,
                "pageSize": 5,
                "size": 1,
                "startRow": 1,
                "endRow": 1,
                "pages": 1,
                "prePage": 0,
                "nextPage": 0,
                "isFirstPage": true,
                "isLastPage": true,
                "hasPreviousPage": false,
                "hasNextPage": false,
                "navigatePages": 8,
                "navigatepageNums": [
                1
                ],
                "navigateFirstPage": 1,
                "navigateLastPage": 1
            }
        }
        let list = result.data.list;
        let teaClass = template('teaClassDoc',list);
        for (let i = 0; i < teaClassDoc.length; i++) {
          teaClassDoc[i].innerHTML = teaClass;
        }
    });


 // 点击指导老师里面的搜索显示出老师的信息
 let tid = '';
 let tids = '';
 let guideTeaSearch = document.querySelector('.teaSearch');
 let guideTea =  document.querySelector('.guideTea');
 let teaInfo = document.querySelector('.teaInfo');
 let  tname = document.querySelector('#contest-name');//指导老师名称
 guideTeaSearch.addEventListener('click',function(ev){
   var oEvent = ev || window.event;
   // 查询获奖人姓名
     let names = tname.value.split(',');
     request
       .request({
         url: '/manangmentSystem/prize/getPrizeWinner',
         params: { username: names},
         method: 'get',
       })
       .then((res) => {
         console.log('查询获奖人名字', res);
         // let list = res.data;
         // 测试的时候需要将result注释掉
         let result = {
           "code": 200,
           "msg": "OK",
           "data": [
             {
               "uid": 2239,
               "username": "张三",
               "roleId": "0",
               "passwd": null,
               "number": "001",
               "identityCard": "41018154894894894",
               "phoneNumber": "13674971648",
               "status": 0,
               "createTime": "2022-02-13T08:20:24.000+00:00",
               "modifiedTime": "2022-02-13T08:20:40.000+00:00",
               "sex": 0,
               "clazz": "",
               "faculty": "计算机与信息技术学院",
               "title": null,
               "grade": "2019",
               "major": "计算机科学与技术",
               "level": 0,
               "teachingResearch": "0"
             },
             {
               "uid": 2352,
               "username": "张2",
               "roleId": "0",
               "passwd": null,
               "number": "003",
               "identityCard": "41011197910220043",
               "phoneNumber": "13674971648",
               "status": 1,
               "createTime": null,
               "modifiedTime": null,
               "sex": 0,
               "clazz": "计科四班",
               "faculty": "计算机与信息技术学院",
               "title": null,
               "grade": "2020",
               "major": "计算机科学与技术",
               "level": null,
               "teachingResearch": "0"
             },
             {
               "uid": 2467,
               "username": "张2",
               "roleId": "0",
               "passwd": null,
               "number": "003",
               "identityCard": "41011197910220043",
               "phoneNumber": "13674971648",
               "status": 1,
               "createTime": null,
               "modifiedTime": null,
               "sex": 0,
               "clazz": "计科四班",
               "faculty": "人工智能学院",
               "title": null,
               "grade": "2020",
               "major": "计算机科学与技术",
               "level": null,
               "teachingResearch": "0"
             },
             {
               "uid": 2275,
               "username": "张2",
               "roleId": "0",
               "passwd": null,
               "number": "003",
               "identityCard": "41011197910220043",
               "phoneNumber": "13674971648",
               "status": 1,
               "createTime": null,
               "modifiedTime": null,
               "sex": 0,
               "clazz": "计科四班",
               "faculty": "人工智能学院",
               "title": null,
               "grade": "2020",
               "major": "计算机科学与技术",
               "level": null,
               "teachingResearch": "0"
             },
             {
               "uid": 6989,
               "username": "张2",
               "roleId": "0",
               "passwd": null,
               "number": "003",
               "identityCard": "41011197910220043",
               "phoneNumber": "13674971648",
               "status": 1,
               "createTime": null,
               "modifiedTime": null,
               "sex": 0,
               "clazz": "计科四班",
               "faculty": "人工智能学院",
               "title": null,
               "grade": "2020",
               "major": "计算机科学与技术",
               "level": null,
               "teachingResearch": "0"
             }
           ]
         }

       let list = result.data;
       // let list = res.data;
       let guideTeaInfo = template('guideTea',list);

       teaInfo.innerHTML = guideTeaInfo;

       guideTea.style.display='block';
       oEvent.cancelBubble = true;

       var teaLis = teaInfo.querySelectorAll('li');
       console.log(teaLis.length);
       tname.value = '';
       let newNames = [];
       let flag = true;
       tid = '';
       tids= '';
       for (let i = 0; i < teaLis.length; i++) {
         teaLis[i].addEventListener('click', function() {

           let ss = this.children[0].innerText;
           let content = tname.value;
           let reg = eval(`/${ss}/ig`);
           if(!reg.test(content)) {
             if(flag) {
               tname.value += ss;
               tid += this.children[2].innerHTML ;
               console.log('进去了');
               newNames.push(this.children[0]);
               tids = tid;
               flag = false;
             }else {
               tname.value += ',' + ss;
               tid +='/' + this.children[2].innerHTML ;
               console.log('进去了');
               newNames.push(this.children[0]);
               tids = tid;
             }

           }else {
             console.log(content);
             console.log('进不去');
             for(let i=0; i<newNames.length; i++) {
              if(this.children[0].innerHTML == newNames[i].innerHTML) {
                 tids = tid.replaceAll(`${newNames[i].parentNode.children[2].innerHTML}`,this.children[2].innerHTML);
                 console.log(tids);
              }
             }
           }
           // console.log(tids);
         })
         
         teaLis[i].addEventListener('mouseover',function(e) {
           this.style.background = '#ddd';
         })
         teaLis[i].addEventListener('mouseout',function(e) {
           this.style.background = '#bbb';
         })

       }

     // 对ul取消冒泡事件
     teaInfo.addEventListener('click', function(ev){
       var oEvent = ev || window.event;
       oEvent.cancelBubble = true;
       this.style.display='block';
     });


     // 点击旁白会关闭弹出层，点击内容区不会关闭
       document.addEventListener('click',()=> {
       guideTea.style.display='none';
     })
   });
 
 });
 console.log(tids);
 console.log('a');




  // 查询学院列表
  // request.get('/manangmentSystem/user/getCollegeList').then((res) => {
  //   console.log('学院列表', res);
  // });

  // 删除单个或多个文件
  // request
  //   .delete('/manangmentSystem/prize/deletePrize', {
  //     data: {
  //       pizIdList: 10,
  //     },
  //   })
  //   .then((res) => {
  //     console.log('删除单个或多个文件', res);
  //   });

  const uploadBtn = document.querySelector('#upload-btn');
  uploadBtn.addEventListener('click', function () {
    var flag = confirm('确定是否提交?');
    if (flag) {
      let pwinner = document.querySelector('#contest-name').value; //获奖人姓名
      let date = document.querySelector('#date').value; //发证时间
      let psponsor = document.querySelector('#organize').value; //发证机构
      let plevel = document.getElementsByName('contest-type'); //奖项分类
      let pname = document.querySelector('.pname').value; //比赛名称
      // let tid = document.querySelector('').value;//指导老师id
      // let uid = JSON.parse(localStorage.getItem('profile')).originalUserDB.uid; //uid
      let catgory = document.getElementsByName('awade-type'); //奖项类别 单人，团体
      let title = document.querySelector('#award-design').value;//称号
      let number = document.querySelector('#certif-id').value;  //证书编号
      let faculty = JSON.parse(localStorage.getItem('profile')).originalUserDB.faculty; //学院
      let grade = JSON.parse(localStorage.getItem('profile')).originalUserDB.grade; //年级
      let level = document.querySelector('#award-level').value; //奖项等级
      console.log(pwinner);
      console.log(111);
  
      // 奖项分类和奖项类别的value
      let plevelValue = checkRadioValue(plevel);
      console.log(plevelValue);
      let catgoryValue = checkRadioValue(catgory);
      console.log(catgoryValue);

      // 表单
      let form = new FormData();
      form.append('organize', organize);

      // 数据
      form.append('file', file);
      form.append('pwinner', pwinner);
      form.append('ptime', date);
      form.append('psponsor', psponsor);
      form.append('plevel', plevelValue);
      form.append('pname', pname);
      form.append('tids', tids);
      form.append('catgory', catgoryValue);
      form.append('title', title);
      form.append('number', number);
      form.append('faculty', faculty);
      form.append('grade', grade);
      form.append('level', level);

      console.log(form);
      for(let keys of form.keys()) {
        console.log(` ${keys} : ${form.get(keys)}`);
      }
      request
        .post(
          '/manangmentSystem/fileOperate/uploadPrize',
          { form },
          { headers: { 'Content-Type': 'multipart/form-data' } }
        )
        .then((res) => {
          console.log(res);
        });
    }
  });



  // 奖项填报
  console.log(1111);
  let data = new FormData();
  data.append('file', 'file.files[0]');
  data.append('pwinner', '<pwinner>');
  data.append('ptime', '<ptime>');
  data.append('psponsor', '<psponsor>');
  data.append('plevel', '<plevel>');
  data.append('pname', '<pname>');
  data.append('tid', '<tid>');
  data.append('uid', '<uid>');
  data.append('category', '<category>');
  data.append('title', '<title>');
  data.append('number', '<number>');
  data.append('tname', '<tname>');
  data.append('faculty', '<faculty>');
  data.append('grade', '<grade>');
  request
    .post('/fileOperate/uploadPrize', data, {
      headers: {
        Content_type: 'multipart/form-data',
      },
    })
    .then((res) => {
      console.log(res);
    });
})();
// 课程大纲模板
let teaClassDocJson = [
  {
    number: 1,
    schooltime: '2022-2023第1学期',
    academy: '计算机与信息技术学院',
    grade: '2020级',
    major: '计算机科学与技术',
    curriculum: '《数据结构》',
    level: '0',
    status: '审核通过',
    operation: 1,
  },
];


// let teaClass = template('teaClassDoc',{
//   items:teaClassDocJson
// });
// for (let i = 0; i < teaClassDoc.length; i++) {
//   teaClassDoc[i].innerHTML = teaClass;
// }
// 审查奖状表格
let awardJson = [
  {
    order: 1,
    number: 12379421321,
    parter: 'Jack',
    competeType: 0,
    competeName: 'XXXXXXXX',
    awardType: 'A类',
    awardLevel: '一等',
    parterTitle: 'XX小标兵',
    parterTeacher: '李四',
    status: '待审核',
    detailsLink: '../../../templates/page/detialIndex/examine/examineAwardDetails.html',
  },
  {
    order: 2,
    number: 12379421321,
    parter: 'Jack',
    competeType: 0,
    competeName: 'XXXXXXXX',
    awardType: 'A类',
    awardLevel: '二等',
    parterTitle: 'XX小标兵',
    parterTeacher: '李四',
    status: '待审核',
    detailsLink: '../../../templates/page/detialIndex/examine/examineAwardDetails.html',
  },
  {
    order: 3,
    number: 12379421321,
    parter: 'Jack',
    competeType: 0,
    competeName: 'XXXXXXXX',
    awardType: 'B类',
    awardLevel: '一等',
    parterTitle: 'XX小标兵',
    parterTeacher: '王五',
    status: '待审核',
    detailsLink: '../../../templates/page/detialIndex/examine/examineAwardDetails.html',
  },
  {
    order: 4,
    number: 12379421321,
    parter: 'Jack',
    competeType: 0,
    competeName: 'XXXXXXXX',
    awardType: 'A类',
    awardLevel: '一等',
    parterTitle: 'XX小标兵',
    parterTeacher: '李四',
    status: '待审核',
    detailsLink: '../../../templates/page/detialIndex/examine/examineAwardDetails.html',
  },
];
