/*TMODJS:{"version":87,"md5":"a18b5da68865d63a2a8b9a8531ccbf50"}*/
template('modifyTeach',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,faculty=$data.faculty,username=$data.username,sex=$data.sex,identityCard=$data.identityCard,number=$data.number,roleId=$data.roleId,passwd=$data.passwd,$out='';$out+='<form method="post" action="" class="form" id="form" onsubmit="onSubmit(event)"> <div class="my-form"> <div class="form-item"> <label for="faculty">学院</label> <span>';
$out+=$escape(faculty);
$out+='</span> </div> <div class="form-item"> <label for="">姓名</label> <input type="text" value="';
$out+=$escape(username);
$out+='" name="username" id="modify-username" pattern="^[0-9]{8,14}|[\\u4e00-\\u9fa5]{2,5}$" class="text-input" required> </div> <div class="form-item"> <label for="usersex">性别</label> <input type="text" value="';
$out+=$escape(sex == 0 ? '男' : '女');
$out+='" name="usersex" id="modify-usersex" class="text-input" pattern="[/^男$|^女&/]" required> </div> <div class="form-item"> <label for="">身份证号</label> <input type="text" name="id-number" value="';
$out+=$escape(identityCard);
$out+='" id="identityCard" class="text-input" placeholder="请输入身份证号(18个字符，仅限大写字母，数字)" pattern="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$" oninvalid="setCustomValidity(\'请输入合法的身份证号>_<\')" required> </div> <div class="form-item"> <label for="">工号</label> <input type="text" name="number" value="';
$out+=$escape(number);
$out+='" class="text-input" id="number" pattern="^[0-9]{8,14}$" required> </div> <div class="form-item"> <label for="office">教研室/部门</label> <select class="select" name="teachingResearch" id="selects"> <option selected value="0">全部</option> <option value="0"> 请选择</option> <option value="1">计算机科学与技术教研室</option> <option value="2">数据科学与大数据技术教研室</option> <option value="3">计算机网络技术教研室</option> <option value="4">物联网应用技术教研室</option> </select> </div> <div class="form-item"> <label for="title">职称</label> <select name="title" id="select" class="select"> <option value="0">请选择</option> <option value="1"> 副教授</option> <option value="2">助教</option> <option value="3">其他正高级</option> <option value="4">其他副高级</option> <option value="5">其他中级</option> <option value="6">其他初级</option> <option value="7">讲师</option> <option value="8">教授</option> </select> </div> <div class="form-item "> <label for="selectrole">选择角色</label> <input type="text " name=" roleId" id="roleId" class="text-input" value="';
$out+=$escape(roleId);
$out+='" required> <input type="checkbox" name="c" id="teacher role" value="1"> <label for="teacher" class="checkbox">普通教师</label> <input type="checkbox" name="c" id="course-leader role" value="2"> <label for="course-leader" class="checkbox">课程负责人</label> <input type="checkbox" name="c" id="director role" value="3"> <label for="director" class="checkbox ">教研室主任</label> </div>  <div class="form-item "> <label>密码</label> <input type="text" name="password" class="text-input" id="password" value="';
$out+=$escape(passwd);
$out+='" placeholder="请输入密码" oninput="onPwdInput(event)" pattern="^\\w{8,20}$" required /> </div> <div class="form-item "> <input type="button" name="btn-modify " value="确定修改" onmousemove="move(event)" class="btn-modify" id="btnmodify" /> </div> </div> </form>';
return new String($out);
});