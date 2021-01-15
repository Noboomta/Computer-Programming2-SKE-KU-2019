#include<stdio.h>
#include<conio.h>
    int find_kcal_usage(int activity_type, float minute, float weight, int gender){
    	
    	//Local valuable init zone
		float kcal_usage = 0.00;
    	float male[5]={1.05,2.84,3.05,6.30,9.45};
		float female[5]={0.97,2.62,2.81,5.82,8.73};
		
		//set coefficient
		float coefficient = 0.00;
		if (gender == 1){
		//male
		coefficient = male[activity_type];
		}
		else if (gender == 2){
		//female
		coefficient = female[activity_type];
		}
		
		kcal_usage = coefficient*minute*weight/60;
		printf("Total kcal usage = %0.2f kcal",kcal_usage);
		return true;
	}	               
main(){

/**
Editted zone 
*/
	int activity_type, minute, weight, gender, kcal_usage;
	bool run = true;
//	while(run){
	printf("Activity type :\n");
	printf("    0:sleep\n");
	printf("    1:wash dish\n");
	printf("    2:take a bath\n");
	printf("    3:play tennis\n");
	printf("    4:punch muay\n");
	printf("input Activity type	: ");
	scanf("%d",&activity_type);
	printf("input minute   		: ");
	scanf("%d",&minute);
	printf("input your weight	: ");
	scanf("%d",&weight);
	printf("input your gender (male press 1) (female press 2) : ");
	scanf("%d",&gender);
	kcal_usage = find_kcal_usage(activity_type, minute, weight, gender);
//	printf("Total kcal = %0.2f",kcal_usage);
//	}
	getch();
	return 0;
}
