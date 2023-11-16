
#include <iostream>

using namespace std;

int main()
{
   int m=26;
   for(int j=0;j<26;j++)
    for(int i=0; i<26; i++)
    if((i*j)%m==1)
        std::cout<<"inv of "<<j<<" is "<<i<<std::endl;
        
        
    
    return 0;
}
