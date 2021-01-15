#include<stdio.h>
#include<conio.h>
     int functionz(int p,int hr,int w,int ch,int pa,float mn,float wa,int g,int ga){
     	float tt,t,ta,aa;
		float y[5]={1.05,2.84,3.05,6.30,9.45};
		float z[5]={0.97,2.62,2.81,5.82,8.73};
		if(ch==1){
		 if(g==1){
		  t=hr;
		  tt=y[p]*t*w;
		  printf("%.2f",tt);
	     }else if(g==2){
	      t=hr;
		  tt=z[p]*t*w;
		  printf("%.2f",tt);
		 }
		}else if(ch==2){
			if(ga==1){
			ta=mn;
			aa=(y[pa]*ta*wa)/60;
			printf("%.2f",aa);
		   }else if (ga==2){
		   	ta=mn;
		   	aa=(z[pa]*ta*wa)/60;
			printf("%.2f",aa);
		   }
	    }
         
     }		               
main(){
         int a,b,c,d,e,f,g,k,ka;
		 printf ("         choose your time    \n");
		 printf ("hour press 1 / minute press 2\n");
		 scanf("%d",&d);
		 if(d==1){
		 printf("0=sleep\n");
		 printf("1=wash dish\n");
		 printf("2=take a bath\n");
		 printf("3=play tennis\n");
		 printf("4=punch muai\n");
		 printf("input kcal:");
         scanf("%d",&a);
         printf("input hour:");
         scanf("%d",&b);
         printf("input your weight:");
         scanf("%d",&c);
         printf("input your gender male press 1 female press 2:");
         scanf("%d",&k);
		 printf("total kcal=");
		 printf("",functionz(a,b,c,d,e,f,g,k,ka));
	   }else if(d==2){
	   	 printf("0=sleep\n");
		 printf("1=wash dish\n");
		 printf("2=take a bath\n");
		 printf("3=play tennis\n");
		 printf("4=punch muai\n");
		 printf("input kcal       :");
         scanf("%d",&e);
         printf("input minute    :");
         scanf("%d",&f);
         printf("input your weight:");
         scanf("%d",&g);
         printf("input your gender male press 1 female press 2:");
         scanf("%d",&ka);
		 printf("total kcal=");
		 printf("",functionz(a,b,c,d,e,f,g,k,ka));
}
 getch();
}
