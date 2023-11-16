/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <string>
using namespace std;

std::string encrypt(std::string plaintext, std::string key){
    
    
    cout<<"Encryption\n";
    cout<<"plaintext: "<<plaintext<<endl;
    std::string tmp ="";
    string tmp2(plaintext.length(), ' ');//[plaintext.length()] ;
    for(int i=0; i< plaintext.length();i++){
        char charPlainText = plaintext[i];
        char charKey = key[i%6] - 'A'+'a';
     
        tmp2[i] = ((char)((charPlainText - 'a' +charKey-'a' )%26 + 'A'));
    }
    cout<<"Chypertext: "<<tmp2<<endl;
    return tmp2;
    
}
std::string decrypt(std::string plaintext, std::string key){
    
    cout<<"Decryption\n";
    
    cout<<"Chypertext: "<<plaintext<<endl;
    
    string tmp2(plaintext.length(), ' ');
    for(int i=0; i< plaintext.size();i++){
        char charPlainText = plaintext[i];
        char charKey = key[i%6] ;
     
        tmp2[i] = ((char)(((charPlainText - 'A' -(charKey-'A') )%26 +26)%26+ 'a'));
        
    }
    cout<<"plaintext: "<<tmp2<<endl;
    return tmp2;
    
}


int main()
{
    string key ="CIPHER";
    cout<<"key: "<<key<<endl;
    string enc= encrypt("thiscryptosystemisnotsecure",key);
    string dec =decrypt(enc,key);
    return 0;
}

