alter table additional_record 
        drop constraint FK_c6j9dv6grn10eyy01kxwunlva;
     

    alter table additional_record 
        drop constraint FK_termui1bv9vhulrsntu41h6jo; 

   alter table additional_record 
        drop constraint FK_xgt04sk86cmdbha806rn6hnq; 
   

    alter table additional_info 
        drop constraint FK_iko938hkakyusbnxvvpgb573t ;
       

    alter table application_records 
        drop constraint FK_mtdfavrm9ncrw9gmxdtqk6ddg ;
      

    alter table application_records 
        drop constraint FK_1lonxkgpgdripjgmb061ulg85 ;
 

    alter table applications 
        drop constraint FK_paq12o1qndons27cxnptxq5xo ;
   

    alter table applications 
        drop constraint FK_kcvgm8wkufnd1xp5xd4bxkqof ;
     

    alter table applications 
        drop constraint FK_2rk16crqegf62ptycwvr10a66 ;
      

    alter table department_majors 
        drop constraint FK_g5v3k1nmrqkernfnj3ckdeflk ;
        
      alter table education_info 
	drop constraint FK_3cuw8njut10xsw5flq54kww79 ;

    alter table education_info 
        drop constraint FK_pqibyb11al1enn5ej5ranwcb5 ;
      

    alter table students 
        drop constraint FK_mxpwo4l2kfhpduw0qdfj6s0e5 ;


drop table users;
drop table additional_record;
drop table additional_info;
drop table application_records;
drop table application_status;
drop table applications;
drop table department_majors;
drop table departments;
drop table education_info;
drop table students;
drop sequence hibernate_sequence;