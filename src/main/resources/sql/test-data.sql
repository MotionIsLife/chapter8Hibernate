INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE)
    VALUES ('Chris', 'Schefer', '1981-05-03');

INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE)
    VALUES ('Scott', 'Tiger', '1990-05-03');

INSERT INTO CONTACT (FIRST_NAME, LAST_NAME, BIRTH_DATE)
    VALUES ('John', 'Smith', '1964-05-03');

INSERT INTO CONTACT_TEL_DETAIL (CONTACT_ID, TEL_TYPE, TEL_NUMBER)
    VALUES (1, 'Mobile', '123412341234');

INSERT INTO CONTACT_TEL_DETAIL (CONTACT_ID, TEL_TYPE, TEL_NUMBER)
    VALUES (1, 'Home', '987987987987');

INSERT INTO CONTACT_TEL_DETAIL (CONTACT_ID, TEL_TYPE, TEL_NUMBER)
    VALUES (2, 'Home', '11111111111');

INSERT INTO HOBBY (HOBBY_ID) VALUES ('SWIMMING');
INSERT INTO HOBBY (HOBBY_ID) VALUES ('JOGGING');
INSERT INTO HOBBY (HOBBY_ID) VALUES ('PROGRAMMING');
INSERT INTO HOBBY (HOBBY_ID) VALUES ('MOVIES');
INSERT INTO HOBBY (HOBBY_ID) VALUES ('READING');

INSERT INTO CONTACT_HOBBY_DETAIL(CONTACT_ID, HOBBY_ID) VALUES (1, 'SWIMMING');
INSERT INTO CONTACT_HOBBY_DETAIL(CONTACT_ID, HOBBY_ID) VALUES (1, 'MOVIES');
INSERT INTO CONTACT_HOBBY_DETAIL(CONTACT_ID, HOBBY_ID) VALUES (2, 'SWIMMING');