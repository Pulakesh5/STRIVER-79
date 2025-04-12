#include <bits/stdc++.h>

pair<int,int> missingAndRepeating(vector<int> &arr, int n)
{
	// Write your code here
	int a=0;
	for(int i=0;i<n;i++){
		a^=(i+1);
		a^=arr[i];
	}
	int pos=0;
	while(!(a&1)){
		a>>=1;
		pos++;
	}
	int first=0;
	int second=0;
	for(int i=0;i<n;i++){
		if((arr[i]>>pos) & 1){
			first^=arr[i];
		}
		else{
			second^=arr[i];
		}
		if(((i+1)>>pos) & 1){
			first^=(i+1);
		}
		else{
			second^=(i+1);
		}
	}
	for(int i=0;i<n;i++){
		if(second == arr[i]){
			swap(second,first);
			break;
		}
	}
	return {second,first};
}
