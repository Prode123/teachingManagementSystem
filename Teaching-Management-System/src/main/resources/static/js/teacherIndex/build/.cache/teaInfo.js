/*TMODJS:{"version":21,"md5":"c61b31130d6f38fd8f7edcca1427cf84"}*/
template('teaInfo',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,username=$data.username,sex=$data.sex,identityCard=$data.identityCard,uid=$data.uid,teachingResearch=$data.teachingResearch,faculty=$data.faculty,phoneNumber=$data.phoneNumber,$out='';$out+=' <div class="info-name"> <span>姓名：</span> <span>';
$out+=$escape(username);
$out+='</span> </div> <div class="info-sex"> <span>性别：</span> <span>';
$out+=$escape(sex == 0 ? '男' : '女');
$out+=' </span> </div> <div class="info-idCard"> <span>身份证号：</span> <span>';
$out+=$escape(identityCard);
$out+='</span> </div> <div class="info-sid"> <span>工号：</span> <span>';
$out+=$escape(uid);
$out+='</span> </div> <div class="info-class"> <span>教研室：</span> <span>';
$out+=$escape(teachingResearch);
$out+='</span> </div> <div class="info-dept"> <span>学院：</span> <span>';
$out+=$escape(faculty);
$out+='</span> </div> <div class="info-phone"> <span>手机号：</span> <span>';
$out+=$escape(phoneNumber);
$out+='</span> </div>';
return new String($out);
});