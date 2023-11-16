/******************************************************************************

Bartłomiej Leśnicki zadanie 2

*******************************************************************************/

#include <iostream>

#include <string>
using namespace std;

int main()
{
    int K[2][2]= {{11,8},{3,7}};
    int det = K[0][0]*K[1][1]-K[1][0]*K[0][1];
    
    cout<<"K:\n"<<K[0][0]<<" "<<K[0][1]<<endl<<K[1][0]<<" "<<K[1][1]<<endl;
    int K_[2][2] ={{K[1][1],-K[0][1]},{-K[1][0],K[0][0]}};
    
    cout<<"\nK_inv:\n"<<K_[0][0]<<" "<<K_[0][1]<<endl<<K_[1][0]<<" "<<K_[1][1]<<endl;
    
    
    cout<<"Encryption\n";
    string plaintext= "july";
    
    cout<<"plaintext: "<<plaintext<<endl;
    string tmp(plaintext.length(),' ');
    int j= plaintext.length()/2;

    for(j=0; j<plaintext.length(); j+=2){
        
        tmp[j]= ((plaintext[j]-'a')*K[0][0]+(plaintext[j+1]-'a')*K[1][0])%26 + 'A';
        tmp[j+1]= ((plaintext[j]-'a')*K[0][1]+(plaintext[j+1]-'a')*K[1][1])%26 + 'A';
      
    }
    cout<<"Chypertext: "<<tmp<<endl;
    
    cout<<"Decryption\n";
    
    string dec(plaintext.length(),' ');
    cout<<"Chypertext: "<<tmp<<endl;
        for(j=0; j<plaintext.length(); j+=2){
        
        dec[j]= ((tmp[j]-'A')*K_[0][0]+(tmp[j+1]-'A')*K_[1][0])%26 + 'a';
        dec[j+1]= ((tmp[j]-'A')*K_[0][1]+(tmp[j+1]-'A')*K_[1][1])%26 + 'a';
      
    }
    cout<<"plaintext: "<<dec<<endl;
    
    return 0;
}

