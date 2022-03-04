window.addEventListener('load', function() {
    let result = {
        code: 200,
        msg: 'OK',
        data: {
            uid: 1,
            username: '程世玉',
            roleId: '1',
            passwd: 'sdfs12434345',
            number: '001347895',
            identityCard: '410422200011248908',
            phoneNumber: '17596568859',
            status: 0,
            createTime: null,
            modifiedTime: null,
            sex: 0,
            clazz: '计科三班',
            faculty: '河南财政金融学院',
            title: '3',
            grade: '2019',
            major: '计算机科学与技术',
            level: 1,
            teachingResearch: 2,
        },
    };
    let List = result.data;
    let teachmessage = document.querySelector('.teach-message');
    let teachTbody = template('modifyTeach', List);
    teachmessage.innerHTML = teachTbody;

    // 选择职称
    function selectors(selectId, checkedvalue) {
        var sel = document.getElementById(selectId);
        for (let i = 0; i < sel.options.length; i++) {
            if (sel.options[i].value == checkedvalue) {
                sel.options[i].selected = true;
                break;
            }
        }
    }
    selectors('select', List.title);

    // 选择角色

    let selectrole = document.querySelector('#roleId'); //复选框选中后所放位置
    let arr = document.querySelectorAll('input[name="c"]'); //复选框input
    let str = '';
    let str1 = ['普通教师', '课程负责人', '教研室主任'];
    let inputids = '';
    for (let i = 0; i < arr.length; i++) {
        arr[i].onclick = function() {
            if (this.checked) {
                str.length === 0 ? (str += str1[i]) : (str += ',' + str1[i]);
                inputids.length === 0 ? (inputids += i + 1) : (inputids += ',' + (i + 1));
            } else {
                str = str.replace(str1[i] + ',', '');
                str = str.replace(',' + str1[i], '');
                str = str.replace(str1[i], '');
                inputids = inputids.replace(i + 1 + ',', '');
                inputids = inputids.replace(',' + (i + 1), '');
                inputids = inputids.replace(i + 1, '');
            }
            selectrole.value = str.trim();
            console.log(inputids);
        };
    }

    function trans(n) {
        let str1 = ['普通教师', '课程负责人', '教研室主任'];
        str = str + str1[n];
        arr[n].checked = 'checked';
        let id = Number(n) + 1;
        inputids += id;
        return (selectrole.value = str);
    }

    trans(List.roleId);

    var btnmodify = document.querySelector('.btn-modify');
    var sendModify = '请确定是否修改';
    let teachjson = {};
    btnmodify.onclick = function() {
        let username = document.querySelector('#modify-username').value; //姓名
        let sexs = document.querySelector('#modify-usersex').value; //性别
        let sex = (sexs == '男' ? 0 : 1)
        let identityCard = document.querySelector('#identityCard').value; //身份证
        let number = document.querySelector('#number').value; //工号
        let passwd = document.querySelector('#password').value; //密码
        let roleId = inputids; //角色
        let select = document.querySelector('#select');
        let title = select.options[select.selectedIndex].value; //职称
        let selects = document.querySelector('#selects');
        let teachingResearch = selects.options[selects.selectedIndex].value; //教研室或部门
        teachjson.username = username;
        teachjson.sex = sex;
        teachjson.identityCard = identityCard;
        teachjson.number = number;
        teachjson.title = title;
        teachjson.roleId = roleId;
        teachjson.passwd = passwd;
        teachjson.teachingResearch = teachingResearch;
        console.log(teachjson); //修改后的教师信息
        Send(sendModify);
    };

    function Send(param) {
        var flag = confirm(param);
        if (!flag) {
            return false;
        }
    }
});