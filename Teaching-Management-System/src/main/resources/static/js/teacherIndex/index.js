const userNavList = [
  { title: '首页', type: 1, icon: 'home' },
  { title: '教学大纲', type: 1, icon: 'outline' },
  { title: '教学进度计划表', type: 1, icon: 'statistics' },
  { title: '人才培养方案', type: 1, icon: 'role-management' },
  {
    type: 2,
    children: [
      { title: '获奖情况', type: 3, icon: 'huojiang' },
      { title: '我的奖状', type: 4 },
      { title: '奖项填报', type: 4 },
    ],
  },
];

// generation leftNav
generationLeftNav(userNavList);

//人才培养方案模板
//1.写json(拿到后端给你的东西,或许是数组)
let teaPersonnelJson = [{
  number:1,
  institute:'计算机与信息技术学院',
  major:'计算机科学与技术',
  grade:'2020级',
  level:"0",
  status:'审核通过',
  operation:0
}];
//2.指定你要的那个特殊的部分
let teaPersonnel = document.querySelector('.tea-personnel-tbody');
//3.套模板template('模板',对象)
let html = template('teaPersonneldoc',{
  items:teaPersonnelJson
});
//4.把template()转换出来的值套入那个特殊的部分里,完成
teaPersonnel.innerHTML = html;

// 课程大纲模板
// let teaClassDocxJson = [{
//   number:1,
//   schooltime:'2022-2023第1学期',
//   academy:'计算机与信息技术学院',
//   grade:'2020级',
//   major:'计算机科学与技术',
//   curriculum:'《数据结构》',
//   level:"0",
//   status:'审核通过',
//   operation:1
// }];

// let teaClassDoc = document.querySelectorAll('.tea-class-tbody');
// let teaClass = template('teaClassDoc',{
//   items:teaClassDocxJson
// });
// for (let i = 0; i < teaClassDoc.length; i++) {
//   teaClassDoc[i].innerHTML = teaClass;
// }

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
                "list": [
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
                      "status": 2,
                      "reason": "2",
                      "auditId": null,
                      "course": "2",
                      "level": 1,
                      "operation":0
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
                          },
              ],
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

//--------------------以下是弹出框的js-----------------------

//上传文件按钮
var aBtn = document.querySelectorAll('.upload-file-btn');
for (var i = 0; i < aBtn.length; i++) {
  aBtn[i].index = i;
  aBtn[i].onclick = function(){
    document.querySelectorAll('.upload-file-files')[this.index].click();
  }
}

//点击上传跳出弹出框
var aBack = document.querySelectorAll('.pop-back');
var aOuter = document.querySelectorAll('.outer-box');
var aLoad = document.querySelectorAll('.load-button');
for (var i = 0; i < aLoad.length; i++) {
  aLoad[i].index = i;
  aLoad[i].onclick = function(){
    aOuter[this.index].classList.add('show');
  }
}
//点击返回退出弹出框
for (var i = 0; i < aBack.length; i++) {
  aBack[i].index = i;
  aBack[i].onclick = function(){
    aOuter[this.index].classList.remove('show');
  }
}

//返回按钮加颜色
for (var i = 0; i < aBack.length; i++) {
  aBack[i].index = i;
  aBack[i].onmouseover = function(){
    aBack[this.index].classList.add('pop-back-active');
  }
  aBack[i].onmouseout = function(){
      aBack[this.index].classList.remove('pop-back-active');
  }
}


//--------------------以上是弹出框的js-----------------------




//-------------------------------以下人才培养方案筛选框的拼接json--------------------------------
//复选框(筛选状态)拼接json
let oStatusForm = document.querySelector('.personnel-status-form');
let aStatusCheckBox = document.querySelectorAll('.personnel-status-checkbox');
//先触发点击事件,给表单里的表单元素套循环
for (var i = 0; i < aStatusCheckBox.length; i++) {
  aStatusCheckBox[i].addEventListener('click', () => {
    for (var i = 0; i < oStatusForm.length; i++) {
      //为每一个表单都设置空数组和空json,方便往里头推得到的checkbox的value
      var arr =[];
      var json = {};
      let checkName = aStatusCheckBox[i].name;
      //如果复选框被选中了
      for (var i = 0; i < aStatusCheckBox.length; i++) {
        if(aStatusCheckBox[i].checked){
          arr.push(aStatusCheckBox[i].value);
        }else {}
      }
      json[checkName] = arr;
      console.log(json);
    }
  });
}


//下拉框
let teaPersonnelForm = document.querySelector('.tea-personnel-form');
let personnelInquireBtn = document.querySelector('.personnel-inquire-button');
personnelInquireBtn.addEventListener('click', () => {
  let json = {};
  for (var i = 0; i < teaPersonnelForm.length-2; i++) {
    json[teaPersonnelForm[i].name] = teaPersonnelForm[i].value;
    console.log(json);
  }
});
//-------------------------------以上人才培养方案筛选框的拼接json--------------------------------