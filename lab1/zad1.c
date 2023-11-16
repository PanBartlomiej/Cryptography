#include <stdio.h>

int main()
{
    char tab[]="attacatonce";
    printf("Encryption\nplaintext:");
    int size_tab=sizeof(tab)/sizeof(char);
    char tab2[size_tab];
    int K=3;
    
    for(int i=0; i<sizeof(tab)/sizeof(char)-1; i++)
    printf("%c",tab[i] );
    printf("\nCyphertext:");
    
    for(int i=0; i<sizeof(tab)/sizeof(char)-1; i++)
       { tab2[i]=tab[i]+K;
        printf("%c",tab2[i]-32 );
       }
       
    printf("\n\nDecryption\nCyphertext");
    char tab3[size_tab];
      for(int i=0; i<sizeof(tab)/sizeof(char)-1; i++)
    {
        tab3[i]=tab2[i]-K;
        
        printf("%c",tab3[i] );
    }
        
    printf("\nplaintext:");
    for(int i=0; i<sizeof(tab)/sizeof(char)-1; i++)
    printf("%c",tab2[i] -32);

  
    return 0;
}
