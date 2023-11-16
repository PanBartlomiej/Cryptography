/******************************************************************************
Zadanie 4 Bartłomiej Leśnicki
*******************************************************************************/

#include <iostream>

using namespace std;

int main()
{
    string Cyphertext="BEEAKFYDJXUQYHYJIQRYHTYJIQFBQDUYJIIKFUHCQD";
    string tmp(Cyphertext.length(),' ');
    for(int i=1; i<26; i++){
        for(int j=0; j<Cyphertext.length(); j++){
            tmp[j]=((Cyphertext[j]-'A'-i)%26 +26)%26+'a';
        }
        cout<<tmp<<endl;
    }
    // klucz to 16

    return 0;
}

