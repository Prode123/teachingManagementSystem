/*TMODJS:{"version":82,"md5":"c692a476f167e71f406866232c4bcb56"}*/
template('modifyStu',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,faculty=$data.faculty,username=$data.username,sex=$data.sex,identityCard=$data.identityCard,number=$data.number,clazz=$data.clazz,passwd=$data.passwd,$out='';$out+='<form method="put" action="" class="form"> <div class="my-form"> <div class="form-item"> <label for="faculty">学院</label> <span>';
$out+=$escape(faculty);
$out+='</span> </div> <div class="form-item"> <label for="">姓名</label> <input type="text" value="';
$out+=$escape(username);
$out+='" name="username" id="modify-username" pattern="^[0-9]{8,14}|[\\u4e00-\\u9fa5]{2,5}$" class="text-input" required> </div> <div class="form-item"> <label for="usersex">性别</label> <input type="text" value="';
$out+=$escape(sex == 0 ? '男' : '女');
$out+='" name="usersex" id="modify-usersex" class="text-input" pattern="[/^男$|^女&/]" required> </div> <div class="form-item"> <label for="">身份证号</label> <input type="text" name="identityCard" value="';
$out+=$escape(identityCard);
$out+='" class="text-input" id="identityCard" placeholder="请输入身份证号(18个字符，仅限大写字母，数字)" pattern="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$" oninvalid="setCustomValidity(\'请输入合法的身份证号>_<\')" required> </div> <div class="form-item"> <label for="">学号</label> <input type="text" name="number" value="';
$out+=$escape(number);
$out+='" class="text-input" id="number" pattern="^[0-9]{8,14}$" required> </div> <div class="form-item"> <label for="major">专业</label> <select name="info-major" id="select" class="select"> <option value="请选择">请选择</option> <option value="计算机科学与技术">计算机科学与技术</option> <option value="数据科学与大数据技术">数据科学与大数据技术</option> <option value="计算机网络技术">计算机网络技术</option> <option value="物联网应用技术">物联网应用技术</option> </select> </div> <div class="form-item"> <label for="levels">层次</label> <select name="info-level" id="selects" class="select"> <option value="请选择">请选择</option> <option value="0">专科</option> <option value="1">本科</option> </select> </div> <div class="form-item"> <label for="grade">年级</label> <select name="info-grade" id="selectss" class="select"> <option value="请选择">请选择</option> <option value="2017">2017级</option> <option value="2018">2018级</option> <option value="2019">2019级</option> <option value="2020">2020级</option> <option value="2021">2021级</option> <option value="2022">2022级</option> <option value="2023">2023级</option> <option value="2024">2024级</option> <option value="2025">2025级</option> </select> </div> <div class="form-item"> <label for="class">班级</label> <!-- <input type="text" name="" value="';
$out+=$escape(clazz);
$out+='" id="classes" class="text-input"> --> <select name="info-class" id="selectsss" class="select"> <option value="请选择">请选择</option> <option value="一班">一班</option> <option value="二班">二班</option> <option value="三班">三班</option> <option value="四班">四班</option> <option value="五班">五班</option> <option value="六班">六班</option> </select> </div> <div class="form-item "> <label>密码</label> <input type="text" name="password" class="text-input" id="password" value="';
$out+=$escape(passwd);
$out+='" placeholder="请输入密码" oninput="onPwdInput(event)" pattern="^\\w{8,20}$" required /> </div> <div class="form-item"> <input type="button" name="btn-modify" value="确定修改" onmousemove="move(event)" class="btn-modify" id="btnmodify" /> </div> </div> </form>';
return new String($out);
});