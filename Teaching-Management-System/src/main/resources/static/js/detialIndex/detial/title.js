window.addEventListener('load', function() {
    function trans(n) {
        let str = '';
        if (n == 20) {
            str = '教学计划表';
        } else if (n == 30) {
            str = '人才培养方案';
        } else if (n == 10) {
            str = '课程介绍';
        } else if (n == 11) {
            str = '理论教学大纲'
        } else if (n == 12) {
            str = '考试大纲';
        } else if (n == 13) {
            str = '实验教学大纲';
        }
        return str;
    }
    let training = {
        "code": 200,
        "msg": "OK",
        "data": {
            "grade": '2020',
            "major": '计算机科学与技术专业',
            "level": 1,
            "fileType": 30,
            "faculty": "计算机与信息技术学院",
            "fileName": "人才培养方案",
            "path": "../../../static/js/detialIndex/PDF/compressed.tracemonkey-pldi-09.pdf"
        }
    };

    // 人才培养方案
    let pjson = training.data;
    pjson.fileType = trans(pjson.fileType);
    let infop = document.querySelector('#personnelTraining');
    let htmlp = template('training', pjson);
    infop && (infop.innerHTML = htmlp);

    // 课程大纲模块（10为课程介绍 11为理论教学大纲 12为考试大纲 13为实验教学大纲）
    let syllabus = {
        "code": 200,
        "msg": "OK",
        "data": {
            "grade": '2020',
            "major": '计算机科学与技术专业',
            "level": 1,
            "fileName": 'Java程序设计',
            "faculty": "计算机与信息技术学院",
            "fileType": 11,
            "path": "../../../static/js/detialIndex/PDF/compressed.tracemonkey-pldi-09.pdf"

        }
    };
    let sjson = syllabus.data;
    sjson.fileType = trans(sjson.fileType);
    let infos = document.querySelector('.syllabus');
    let htmls = template('syllabus', sjson);
    infos && (infos.innerHTML = htmls);

    // 教学计划表
    let schedule = {
        "code": 200,
        "msg": "OK",
        "data": {
            "grade": '2020',
            "major": '计算机科学与技术专业',
            "level": 1,
            "faculty": "计算机与信息技术学院",
            "fileName": '计算机原理',
            "fileType": 20,
            "path": "../../../static/js/detialIndex/PDF/compressed.tracemonkey-pldi-09.pdf"

        }
    };
    let tjson = schedule.data;
    tjson.fileType = trans(tjson.fileType);

    let infot = document.querySelector('#schedule');
    let htmlt = template('schedule', tjson);
    infot && (infot.innerHTML = htmlt);
});