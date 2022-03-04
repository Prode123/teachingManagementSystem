// navList    type: 1 -----> 一级导航  2 -----> 二级导航,没有title,children[0]为二级导航名 3 -----> 二级导航名  4----> 二级导航菜单项
const userNavList = [

    { title: '首页', type: 1, icon: 'home' },
    { title: '角色信息管理', type: 1, icon: 'role-management' },
    { title: '角色权限管理', type: 1, icon: 'authority-management' },
    {
        type: 2,
        children: [
            { title: '审查', type: 3, icon: 'examine' },
            { title: '审查奖项', type: 4 },
            { title: '审查文件', type: 4 },
            { title: '发送通知', type: 4 }
        ],
    },
    {
        title: '数据导出',
        type: 1,
        icon: 'role-management'
    }
];


//下拉框样式
let select = document.querySelectorAll('.select');
for (var i = 0; i < select.length; i++) {
    select[i].index = i;
    select[i].onchange = function() {
        this.classList.add('active');
    }
}
//------------------------------------------以下是表格模板----------------------------------------
//学生信息表格
let stuJson = {
    "code": 200,
    "msg": "OK",
    "data": [{
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
    }, {
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
    }, {
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
    }, {
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
    }]
};
let stu = document.querySelector('.stu-tbody');
let stuTbody = template('stuTable', stuJson.data);
stu.innerHTML = stuTbody;

//--------------------教师信息表格-----------------
let teaJson = {
    "code": 200,
    "msg": "OK",
    "data": [{
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
    }, {
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
    }, {
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
    }, {
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
    }]
};
let tea = document.querySelector('.tea-tbody');
let teaTbody = template('teaTable', teaJson.data);
tea.innerHTML = teaTbody;

//----------------------------审查奖状表格-------------------
let awardJson = {
    "code": 200,
    "msg": "OK",
    "data": [{
        "pizId": 1,
        "ptime": "2022-02-09T01:21:59.000+00:00",
        "pwinner": "张三",
        "psponsor": "河南财政金融学院",
        "plevel": "A",
        "level": "一等奖",
        "category": 1,
        "title": "1",
        "number": "201900001",
        "pname": "ACM",
        "tid": "2",
        "tname": "老赵,黄老师,李老师",
        "pathFront": "/img/a.png",
        "createTime": "2022-02-09T01:24:24.000+00:00",
        "modifiedTime": "2022-02-09T01:24:26.000+00:00",
        "uid": 1,
        "faculty": "河南财政金融学院",
        "grade": "2019",
        "status": 0,
        "reason": null,
        "auditId": null,
        "isDelete": null
    }, {
        "pizId": 1,
        "ptime": "2022-02-09T01:21:59.000+00:00",
        "pwinner": "张三",
        "psponsor": "河南财政金融学院",
        "plevel": "A",
        "level": "一等奖",
        "category": 1,
        "title": "1",
        "number": "201900001",
        "pname": "ACM",
        "tid": "2",
        "tname": "老赵,黄老师,李老师",
        "pathFront": "/img/a.png",
        "createTime": "2022-02-09T01:24:24.000+00:00",
        "modifiedTime": "2022-02-09T01:24:26.000+00:00",
        "uid": 1,
        "faculty": "河南财政金融学院",
        "grade": "2019",
        "status": 0,
        "reason": null,
        "auditId": null,
        "isDelete": null
    }]
};
let award = document.querySelector('.award-tbody');
let awardTbody = template('awardTable', awardJson.data);
award.innerHTML = awardTbody;

//审查文件表格
let docJson = {
    "code": 200,
    "msg": "OK",
    "data": [{
        "did": 1,
        "path": "http://127.0.0.1/static/file/Java课程大纲.pdf",
        "size": 120,
        "fileName": "Java课程大纲",
        "fileType": 11,
        "createTime": "2022-02-09T01:19:48.000+00:00",
        "modifiedTime": "2022-02-09T01:19:51.000+00:00",
        "grade": "2019",
        "semester": 8,
        "faculty": "计算机与信息技术学院",
        "major": "计算机科学与技术学院",
        "uid": 1,
        "status": 0,
        "reason": null,
        "auditId": null,
        "course": "Java课程设计大纲",
        "level": 1
    }, {
        "did": 1,
        "path": "http://127.0.0.1/static/file/Java课程大纲.pdf",
        "size": 120,
        "fileName": "Java课程大纲",
        "fileType": 11,
        "createTime": "2022-02-09T01:19:48.000+00:00",
        "modifiedTime": "2022-02-09T01:19:51.000+00:00",
        "grade": "2019",
        "semester": 8,
        "faculty": "计算机与信息技术学院",
        "major": "计算机科学与技术学院",
        "uid": 1,
        "status": 0,
        "reason": null,
        "auditId": null,
        "course": "Java课程设计大纲",
        "level": 1
    }, {
        "did": 1,
        "path": "http://127.0.0.1/static/file/Java课程大纲.pdf",
        "size": 120,
        "fileName": "Java课程大纲",
        "fileType": 11,
        "createTime": "2022-02-09T01:19:48.000+00:00",
        "modifiedTime": "2022-02-09T01:19:51.000+00:00",
        "grade": "2019",
        "semester": 8,
        "faculty": "计算机与信息技术学院",
        "major": "计算机科学与技术学院",
        "uid": 1,
        "status": 0,
        "reason": null,
        "auditId": null,
        "course": "Java课程设计大纲",
        "level": 1
    }]
};
let doc = document.querySelector('.doc-tbody');
var docTbody = template('docTable', docJson.data);
doc.innerHTML = docTbody;

//获取学院(暂时用不到)
let facultyJson = {};
let faculty = document.querySelectorAll('item-screen-span');
var facultySpan = template('faculty', )


//------------------------------------------以上是表格模板----------------------------------------

//------------------------------------------以下是拼接json----------------------------------------
//学生信息表单查询json
var stuForm = document.querySelector('.stu-form');
var stuBtn = document.querySelector('#stu-inquire');
stuBtn.addEventListener('click', () => {
    let json = {};
    console.log(stuForm);
    for (var i = 0; i < stuForm.length - 2; i++) {
        json[stuForm[i].name] = stuForm[i].value;
    }
    console.log(json);
});

//教师信息表单查询json
var teaFrom = document.querySelector('.tea-form');
var teaBtn = document.querySelector('#tea-inquire');
teaBtn.addEventListener('click', () => {
    let json = {};
    for (var i = 0; i < teaFrom.length - 2; i++) {
        json[teaFrom[i].name] = teaFrom[i].value;
    }
    console.log(json);
});

//审查奖状筛选框拼接json
var oAwardForm = document.querySelector('.award-inquire-form');
var aAwardCheckBox = document.querySelectorAll('.award-check');
//监听复选框是否被点击
for (var i = 0; i < aAwardCheckBox.length; i++) {
    //如果被点击了,就遍历表单,给值推到数组里
    aAwardCheckBox[i].addEventListener('click', () => {
        for (var i = 0; i < oAwardForm.length - 2; i++) {
            var arr = [];
            var json = {};
            let checkName = aAwardCheckBox[i].name;
            for (var i = 0; i < aAwardCheckBox.length; i++) {
                if (aAwardCheckBox[i].checked) {
                    arr.push(aAwardCheckBox[i].value);
                } else {}
            }
            json[checkName] = arr;
            console.log(json);
        }
    });
}

//审查文件筛选框拼接json
var oDocForm = document.querySelector('.doc-inquire-form');
var aDocCheckBox = document.querySelectorAll('.doc-check');
for (var i = 0; i < aDocCheckBox.length; i++) {
    aDocCheckBox[i].addEventListener('click', () => {
        for (var i = 0; i < oDocForm.length; i++) {
            var arr = [];
            var json = {};
            let checkName = aDocCheckBox[i].name;
            for (var i = 0; i < aDocCheckBox.length; i++) {
                if (aDocCheckBox[i].checked) {
                    arr.push(aDocCheckBox[i].value);
                } else {}
            }
            json[checkName] = arr;
            console.log(json);
        }
    })
}

//------------------------------------------以上是拼接json----------------------------------------

// generation leftNav
generationLeftNav(userNavList);
// request.get("").then((res) => {
// 
// });