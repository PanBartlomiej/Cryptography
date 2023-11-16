/******************************************************************************

Bartłomiej Leśnicki zadanie 3
*******************************************************************************/

#include <iostream>

using namespace std;

int main()
{
    string Cyphertext="TGEEMNELNNTDROEOAAHDOETCSHAEIRLM";
    int tab_1[8]={2,4,6,1,8,3,5,7};
    int tab_2[8]={4,1,6,2,7,3,8,5};
    
    int siz = Cyphertext.length();
    string plaintext(siz,' ');
    int j=-1;
    
        int i=0;
        cout<<"Decryption\n";
    cout<<"Chypertext: "<<Cyphertext<<endl;
    while(i<=32){
        if(i%8==0)
        j++;
        plaintext[i] = Cyphertext[j*8+tab_1[i%8]-1]-'A'+'a';
        i++;
        
    }  
     j=-1;
    cout<<"plaintext: "<<plaintext<<endl;
    while(i<32){
        if(i%8==0)
        j++;
        Cyphertext[i]= plaintext[j*8+tab_2[i%8]-1]-'A'+'a';
        i++;
        
    }
    cout<<"\nEncryption\n";
    cout<<"plaintext: "<<plaintext<<endl;
    
    cout<<"Chypertext: "<<Cyphertext<<endl;

    
    return 0;
}

