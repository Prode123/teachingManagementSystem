"use strict";
window.addEventListener("load", function() {
    let result = {
        "code": 200,
        "msg": "OK",
        "data": {
            "uid": 1,
            "username": "程世玉",
            "roleId": "0",
            "passwd": "sdfs12434345",
            "number": "001347895",
            "identityCard": "410422200011248908",
            "phoneNumber": "13674971648",
            "status": 0,
            "createTime": null,
            "modifiedTime": null,
            "sex": 0,
            "clazz": "三班",
            "faculty": "河南财政金融学院",
            "title": "",
            "grade": "2019",
            "major": "计算机科学与技术",
            "level": 1,
            "teachingResearch": null
        }
    }
    let List = result.data;
    let stumessage = document.querySelector('.stu-message');
    let stuTbody = template('modifyStu', List);
    stumessage.innerHTML = stuTbody;



    // 根据修改前渲染的模拟数据，使下拉框部分的内容选中
    function selectors(selectId, checkedvalue) {
        var sel = document.getElementById(selectId);
        for (let i = 0; i < sel.options.length; i++) {
            if (sel.options[i].value == checkedvalue) {
                sel.options[i].selected = true;
                return sel.options[i].value;
                break;
            }
        }
    }

    // 选择专业 id="select"
    selectors('select', List.major);
    // 选择层次 id="selects"
    selectors('selects', List.level);
    //选择年级 id="selectss"
    selectors('selectss', List.grade);
    //选择年级 id="selectsss"
    selectors('selectsss', List.clazz);
    // 填写数据组合为json
    var form = this.document.querySelector('form');

    var btnmodify = document.querySelector('.btn-modify');
    let select = document.querySelector("#select");
    var sendModify = "请确定是否修改";
    let stujson = {};
    btnmodify.onclick = function() {

        let username = document.querySelector('#modify-username').value; //姓名

        let sexs = document.querySelector('#modify-usersex').value; //性别
        let sex = (sexs == '男' ? 0 : 1)
        let identityCard = document.querySelector('#identityCard').value; //身份证
        let number = document.querySelector('#number').value; //学号
        let selectsss = document.querySelector("#selectsss");
        let clazz = selectsss.options[selectsss.selectedIndex].value;
        let passwd = document.querySelector('#password').value; //密码
        let major = select.value;
        let selects = document.querySelector("#selects");
        let level = selects.options[selects.selectedIndex].value; //层次
        let selectss = document.querySelector("#selectss");
        let grade = selectss.options[selectss.selectedIndex].value; //年级
        stujson.username = username;
        stujson.sex = sex;
        stujson.identityCard = identityCard;
        stujson.number = number;
        stujson.clazz = clazz;
        stujson.passwd = passwd;
        stujson.major = major;
        stujson.level = level;
        stujson.grade = grade;
        stujson.roleId = "0"; //角色
        console.log(stujson); //修改后的学生信息
        // Send(sendModify);//确定修改的提示信息


        // 以下异步代码

    }

    function Send(param) {
        var flag = confirm(param);
        if (!flag) {
            return false;
        }
    }
})