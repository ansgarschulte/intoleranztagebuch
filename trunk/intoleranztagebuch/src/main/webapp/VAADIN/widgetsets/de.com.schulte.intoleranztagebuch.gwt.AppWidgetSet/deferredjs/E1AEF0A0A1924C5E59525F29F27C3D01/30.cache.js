function _Q(){}
function WQ(){}
function a2(){}
function d2(){}
function h2(){}
function f2(){}
function V3(){}
function Eub(){}
function Dub(){}
function T4b(){}
function h5b(){}
function l5b(){}
function p5b(){}
function t5b(){}
function i5b(b){this.b=b}
function m5b(b){this.b=b}
function q5b(b){bb();this.b=b}
function f5b(b,c){b.enctype=c;b.encoding=c}
function kzb(b,c){b.onload=function(){c.Nf()}}
function V4b(b){VAb(b.n,false);b.o||(b.e.Lb[eoc]=true,undefined);b.d=false}
function W4b(b){VAb(b.n,true);b.e.Lb[eoc]=false;b.d=true;if(b.o){U4b(b);b.o=false}}
function U4b(b){if(b.p){$doc.body.removeChild(b.p);b.p.onload=null;b.p=null}}
function W3(){var b;this.Lb=(b=$doc.createElement(ioc),b.type=soc,b)}
function Z4b(b,c){if(b.f!=c){b.f=c;if(b.f){n$(b.e,1024);n$(b.e,2048)}}ZZ(b.Lb,'v-upload-immediate',b.f)}
function Y4b(b){P$(b.k,b.n);P$(b.k,b.e);b.e=new u5b(b);b.e.Lb.name=b.j+txc;b.e.Lb[eoc]=!b.d;T2(b.k,b.e);T2(b.k,b.n);b.f&&n$(b.e,1024)}
function bR(){ZQ=new _Q;Ub((Sb(),Rb),30);!!$stats&&$stats(xc(rxc,Cmc,-1,-1));ZQ.Jc();!!$stats&&$stats(xc(rxc,uuc,-1,-1))}
function $Q(){var b,c,d;while(XQ){d=nb;XQ=XQ.b;!XQ&&(YQ=null);if(!d){(fsb(),esb).lg(vF,new Eub);Ijb()}else{try{(fsb(),esb).lg(vF,new Eub);Ijb()}catch(b){b=BI(b);if($q(b,37)){c=b;Bpb.xe(c)}else throw b}}}}
function u5b(b){var c;this.b=b;this.Lb=(c=$doc.createElement(ioc),c.type='file',c);this.Lb[Vnc]='gwt-FileUpload';this.c=new h2;this.c.d=this;this.Ib==-1?PX(this.Lb,4096|(this.Lb.__eventBits||0)):(this.Ib|=4096)}
function $4b(b){if(b.e.Lb.value.length==0||b.o||!b.d){Bpb.ze('Submit cancelled (disabled, no file or already submitted)');return}dhb(b.b);b.c.submit();b.o=true;Bpb.ze('Submitted form');V4b(b);b.q=new q5b(b);db(b.q,800)}
function g2(b,c){var d;switch(PY(c.type)){case 1024:if(!b.b){b.c=true;return false}break;case 4096:if(b.c){b.b=true;b.d.Lb.dispatchEvent((d=$doc.createEvent(sxc),d.initEvent(Ymc,false,true),d));b.b=false;b.c=false}}return true}
function X4b(b){var c;if(!b.p){c=$doc.createElement(qoc);c.innerHTML="<iframe src=\"javascript:''\" name='"+b.j+"_TGT_FRAME' style='position:absolute;width:0;height:0;border:0'>"||xmc;b.p=Qd(c);$doc.body.appendChild(b.p);b.c.target=b.j+'_TGT_FRAME';kzb(b.p,b)}}
function _4b(){this.Lb=$doc.createElement('form');this.e=new u5b(this);this.k=new W2;this.g=new W3;this.c=this.Lb;f5b(this.Lb,gwc);this.c.method='post';$0(this,this.k);T2(this.k,this.g);T2(this.k,this.e);this.n=new XAb;e$(this.n,new i5b(this),(dk(),dk(),ck));T2(this.k,this.n);this.Lb[Vnc]='v-upload';this.Ib==-1?PX(this.Lb,241|(this.Lb.__eventBits||0)):(this.Ib|=241)}
var txc='_file',uxc='buttoncaption',rxc='runCallbacks30';_=_Q.prototype=WQ.prototype=new J;_.gC=function aR(){return Yu};_.Jc=function eR(){$Q()};_.cM={};_=a2.prototype=new DZ;_.gC=function b2(){return Hw};_.Oc=function c2(b){g2(this.c,b)&&i$(this,b)};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.c=null;_=d2.prototype=new J;_.gC=function e2(){return Gw};_.cM={};_=h2.prototype=f2.prototype=new d2;_.gC=function i2(){return Fw};_.cM={};_.b=false;_.c=false;_.d=null;_=W3.prototype=V3.prototype=new DZ;_.gC=function X3(){return Ww};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=Eub.prototype=Dub.prototype=new J;_.Ke=function Fub(){return new _4b};_.gC=function Gub(){return BA};_.cM={137:1};_=_4b.prototype=T4b.prototype=new X0;_.gC=function a5b(){return vF};_.ed=function b5b(){h$(this);!!this.b&&X4b(this)};_.Oc=function c5b(b){(PY(b.type)&241)>0&&(irb(this.b.G,b,this,null),undefined);i$(this,b)};_.fd=function d5b(){j$(this);this.o||U4b(this)};_.Nf=function e5b(){_qb((Gc(),Fc),new m5b(this))};_.Yd=function g5b(b,c){var d;if(lhb(c,this,b,true)){return}if('notStarted' in b[1]){db(this.q,400);return}if('forceSubmit' in b[1]){$4b(this);return}Z4b(this,Boolean(b[1][npc]));this.b=c;this.j=b[1][moc];this.i=b[1]['nextid'];d=ihb(c,b[1][qpc][Ysc]);this.c.action=d;if(uxc in b[1]){this.n.c.textContent=b[1][uxc]||xmc;this.n.Lb.style.display=xmc}else{this.n.Lb.style.display=Rmc}this.e.Lb.name=this.j+txc;if(eoc in b[1]||lpc in b[1]){V4b(this)}else if(!Boolean(b[1][Hpc])){W4b(this);X4b(this)}};_.cM={10:1,13:1,15:1,17:1,19:1,20:1,21:1,22:1,26:1,33:1,69:1,70:1,75:1,76:1};_.b=null;_.c=null;_.d=true;_.f=false;_.i=0;_.j=null;_.n=null;_.o=false;_.p=null;_.q=null;_=i5b.prototype=h5b.prototype=new J;_.gC=function j5b(){return rF};_.ec=function k5b(b){this.b.f?(this.b.e.Lb.click(),undefined):$4b(this.b)};_.cM={12:1,39:1};_.b=null;_=m5b.prototype=l5b.prototype=new J;_.Wb=function n5b(){if(this.b.o){if(this.b.b){!!this.b.q&&cb(this.b.q);Bpb.ze('VUpload:Submit complete');dhb(this.b.b)}Y4b(this.b);this.b.o=false;W4b(this.b);this.b.Hb||U4b(this.b)}};_.gC=function o5b(){return sF};_.cM={3:1,14:1};_.b=null;_=q5b.prototype=p5b.prototype=new $;_.gC=function r5b(){return tF};_.Sb=function s5b(){Bpb.ze('Visiting server to see if upload started event changed UI.');Dgb(this.b.b,this.b.j,'pollForStart',xmc+this.b.i,true,105)};_.cM={65:1};_.b=null;_=u5b.prototype=t5b.prototype=new a2;_.gC=function v5b(){return uF};_.Oc=function w5b(b){g2(this.c,b)&&i$(this,b);if(PY(b.type)==1024){this.b.f&&this.b.e.Lb.value!=null&&!mec(xmc,this.b.e.Lb.value)&&$4b(this.b)}else if((Tkb(),!Skb&&(Skb=new mlb),Tkb(),Skb).b.i&&PY(b.type)==2048){this.b.e.Lb.click();this.b.e.Lb.blur()}};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.b=null;var Yu=Tcc(fuc,'AsyncLoader30'),Hw=Tcc(iuc,'FileUpload'),Gw=Tcc(iuc,'FileUpload$FileUploadImpl'),Fw=Tcc(iuc,'FileUpload$FileUploadImplOpera'),Ww=Tcc(iuc,'Hidden'),BA=Tcc(puc,'WidgetMapImpl$39$1'),rF=Tcc(ouc,'VUpload$1'),sF=Tcc(ouc,'VUpload$2'),tF=Tcc(ouc,'VUpload$3'),uF=Tcc(ouc,'VUpload$MyFileUpload');tmc(bR)();