function mT(){}
function hT(){}
function s2(){}
function f4(){}
function Gvb(){}
function Fvb(){}
function F5b(){}
function h5b(){}
function x5b(){}
function B5b(){}
function J5b(){}
function y5b(b){this.a=b}
function C5b(b){this.a=b}
function G5b(b){bb();this.a=b}
function v5b(b,c){b.enctype=c;b.encoding=c}
function g4(){var b;this.Kb=(b=$doc.createElement(Foc),b.type=Noc,b)}
function K5b(b){var c;this.a=b;this.Kb=(c=$doc.createElement(Foc),c.type='file',c);this.Kb[roc]='gwt-FileUpload'}
function k5b(b){jBb(b.k,true);b.d.Kb[Coc]=false;b.c=true;if(b.n){i5b(b);b.n=false}}
function j5b(b){jBb(b.k,false);b.n||(b.d.Kb[Coc]=true,undefined);b.c=false}
function i5b(b){if(b.o){$doc.body.removeChild(b.o);b.o.onreadystatechange=null;b.o=null}}
function Azb(b,c){b.onreadystatechange=function(){b.readyState=='complete'&&c.Nf()}}
function n5b(b,c){if(b.e!=c){b.e=c;if(b.e){F$(b.d,1024);F$(b.d,2048)}}p$(b.Kb,'v-upload-immediate',b.e)}
function m5b(b){f_(b.j,b.k);f_(b.j,b.d);b.d=new K5b(b);b.d.Kb.name=b.i+uzc;b.d.Kb[Coc]=!b.c;d3(b.j,b.d);d3(b.j,b.k);b.e&&F$(b.d,1024)}
function oT(){kT=new mT;Ub((Sb(),Rb),36);!!$stats&&$stats(xc(tzc,Smc,-1,-1));kT.Jc();!!$stats&&$stats(xc(tzc,Puc,-1,-1))}
function lT(){var b,c,d;while(iT){d=nb;iT=iT.a;!iT&&(jT=null);if(!d){(vsb(),usb).lg(IF,new Gvb);Yjb()}else{try{(vsb(),usb).lg(IF,new Gvb);Yjb()}catch(b){b=OI(b);if(or(b,37)){c=b;Rpb.xe(c)}else throw b}}}}
function o5b(b){if(b.d.Kb.value.length==0||b.n||!b.c){Rpb.ze('Submit cancelled (disabled, no file or already submitted)');return}thb(b.a);b.b.submit();b.n=true;Rpb.ze('Submitted form');j5b(b);b.p=new G5b(b);db(b.p,800)}
function l5b(b){var c;if(!b.o){c=Wd($doc,cnc);c.innerHTML="<iframe src=\"javascript:''\" name='"+b.i+"_TGT_FRAME' style='position:absolute;width:0;height:0;border:0'>"||Nmc;b.o=Sd(c);$doc.body.appendChild(b.o);b.b.target=b.i+'_TGT_FRAME';Azb(b.o,b)}}
function p5b(){this.Kb=Wd($doc,'form');this.d=new K5b(this);this.j=new g3;this.f=new g4;this.b=this.Kb;v5b(this.Kb,Kwc);this.b.method='post';q1(this,this.j);d3(this.j,this.f);d3(this.j,this.d);this.k=new lBb;w$(this.k,new y5b(this),(tk(),tk(),sk));d3(this.j,this.k);this.Kb[roc]='v-upload';this.Hb==-1?aY(this.Kb,241|(this.Kb.__eventBits||0)):(this.Hb|=241)}
var uzc='_file',vzc='buttoncaption',tzc='runCallbacks36';_=mT.prototype=hT.prototype=new J;_.gC=function nT(){return Cv};_.Jc=function rT(){lT()};_.cM={};_=s2.prototype=new VZ;_.gC=function t2(){return Uw};_.Oc=function u2(b){A$(this,b)};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=g4.prototype=f4.prototype=new VZ;_.gC=function h4(){return hx};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=Gvb.prototype=Fvb.prototype=new J;_.Ke=function Hvb(){return new p5b};_.gC=function Ivb(){return ZA};_.cM={137:1};_=p5b.prototype=h5b.prototype=new n1;_.gC=function q5b(){return IF};_.ed=function r5b(){z$(this);!!this.a&&l5b(this)};_.Oc=function s5b(b){(bZ(b.type)&241)>0&&(yrb(this.a.F,b,this,null),undefined);A$(this,b)};_.fd=function t5b(){B$(this);this.n||i5b(this)};_.Nf=function u5b(){prb((Gc(),Fc),new C5b(this))};_.Yd=function w5b(b,c){var d;if(Bhb(c,this,b,true)){return}if('notStarted' in b[1]){db(this.p,400);return}if('forceSubmit' in b[1]){o5b(this);return}n5b(this,Boolean(b[1][Jpc]));this.a=c;this.i=b[1][Ioc];this.g=b[1]['nextid'];d=yhb(c,b[1][Mpc][qtc]);this.b.action=d;if(vzc in b[1]){this.k.b.innerText=b[1][vzc]||Nmc;this.k.Kb.style.display=Nmc}else{this.k.Kb.style.display=pnc}this.d.Kb.name=this.i+uzc;if(Coc in b[1]||Hpc in b[1]){j5b(this)}else if(!Boolean(b[1][bqc])){k5b(this);l5b(this)}};_.cM={10:1,13:1,15:1,17:1,19:1,20:1,21:1,22:1,26:1,33:1,69:1,70:1,75:1,76:1};_.a=null;_.b=null;_.c=true;_.e=false;_.g=0;_.i=null;_.k=null;_.n=false;_.o=null;_.p=null;_=y5b.prototype=x5b.prototype=new J;_.gC=function z5b(){return EF};_.ec=function A5b(b){this.a.e?(this.a.d.Kb.click(),undefined):o5b(this.a)};_.cM={12:1,39:1};_.a=null;_=C5b.prototype=B5b.prototype=new J;_.Vb=function D5b(){if(this.a.n){if(this.a.a){!!this.a.p&&cb(this.a.p);Rpb.ze('VUpload:Submit complete');thb(this.a.a)}m5b(this.a);this.a.n=false;k5b(this.a);this.a.Gb||i5b(this.a)}};_.gC=function E5b(){return FF};_.cM={3:1,14:1};_.a=null;_=G5b.prototype=F5b.prototype=new $;_.gC=function H5b(){return GF};_.Rb=function I5b(){Rpb.ze('Visiting server to see if upload started event changed UI.');Tgb(this.a.a,this.a.i,'pollForStart',Nmc+this.a.g,true,105)};_.cM={65:1};_.a=null;_=K5b.prototype=J5b.prototype=new s2;_.gC=function L5b(){return HF};_.Oc=function M5b(b){A$(this,b);if(bZ(b.type)==1024){this.a.e&&this.a.d.Kb.value!=null&&!Cec(Nmc,this.a.d.Kb.value)&&o5b(this.a)}else if((hlb(),!glb&&(glb=new Clb),hlb(),glb).a.g&&bZ(b.type)==2048){this.a.d.Kb.click();this.a.d.Kb.blur()}};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.a=null;var Cv=hdc(Auc,'AsyncLoader36'),Uw=hdc(Duc,'FileUpload'),hx=hdc(Duc,'Hidden'),ZA=hdc(Kuc,'WidgetMapImpl$48$1'),EF=hdc(Juc,'VUpload$1'),FF=hdc(Juc,'VUpload$2'),GF=hdc(Juc,'VUpload$3'),HF=hdc(Juc,'VUpload$MyFileUpload');Jmc(oT)();