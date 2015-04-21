/* Largest Donation Per Donor */

  /* Individual */
  SELECT Fname, Lname, MAX(Amount)
  FROM INDIVIDUAL AS I, DONOR AS D, DONATIONS AS DA
  INNER JOIN I, D, DA
  ON I.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY I.Lname

  /* Corporate/Organization */
  SELECT Fname, Lname, MAX(Amount)
  FROM CORPORATE_ORGANIZATION, DONOR AS D, DONATIONS AS DA
  INNER JOIN CO, D, DA
  ON CO.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY CO.OrgName

  /* Grants */
  SELECT GrantName, MAX(Amount)
  FROM GRANT AS G, DONOR AS D, DONATIONS AS DA
  INNER JOIN G, D, DA
  ON G.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY G.GrantName

/* Average Donations per donor */

  /* Individual */
  SELECT Fname, Lname, AVG(Amount)
  FROM INDIVIDUAL AS I, DONOR AS D, DONATIONS AS DA
  INNER JOIN I, D, DA
  ON I.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY I.Lname

  /* Corporate/Organization */
  SELECT OrgName, AVG(Amount)
  FROM CORPORATE_ORGANIZATION AS CO, DONOR AS D, DONATIONS AS DA
  INNER JOIN CO, D, DA
  ON CO.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY CO.OrgName

  /* Grant */
  SELECT GrantName, AVG(Amount)
  FROM GRANT AS G, DONOR AS D, DONATIONS AS DA
  INNER JOIN G, D, DA
  ON G.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY G.GrantName;

/* Count Number of Donations Per Donor */

  /* Individual */
  SELECT Fname, Lname, COUNT(DonationID)
  FROM INDIVIDUAL AS I, DONOR AS D, DONATIONS AS DA
  INNER JOIN I, D, DA
  ON I.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY I.Lname

  /* Corporate/Organization */
  SELECT OrgName, COUNT(DonationID)
  FROM CORPORATE_ORGANIZATION AS CO, DONOR AS D, DONATIONS AS DA
  INNER JOIN CO, D, DA
  ON CO.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY CO.OrgName

  /* Grant */
  SELECT Fname, Lname, COUNT(DonationID)
  FROM GRANT AS G, DONOR AS D, DONATIONS AS DA
  INNER JOIN G, D, DA
  ON G.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY G.GrantName

/* Total Amount Donated Per Donor Type */

  /* Individual */
  SELECT Fname, Lname, SUM(Amount)
  FROM INDIVIDUAL AS I, DONOR AS D, DONATIONS AS DA
  INNER JOIN I, D, DA
  ON I.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY I.Lname

  /* Corporate/Organization */
  SELECT OrgName, SUM(Amount)
  FROM CORPORATE_ORGANIZATION AS CO, DONOR AS D, DONATIONS AS DA
  INNER JOIN CO, D, DA
  ON CO.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY CO.OrgName

  /* Grant */
  SELECT GrantName, SUM(Amount)
  FROM GRANT AS G, DONOR AS D, DONATIONS AS DA
  INNER JOIN G, D, DA
  ON G.DonorID = D.DonorID AND D.DonorID = DA.DonorID
  GROUP BY G.GrantName

/* Group Donors By Locations */

  /* Grouping Individuals */
    /* By City */
    SELECT Fname, Lname, City, State, Zipcode
    FROM INDIVIDUAL AS I, DONOR AS D, DONATIONS AS DA
    INNER JOIN I, D, DA
    ON I.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    Group By D.City

    /* By State */
    SELECT Fname, Lname, City, State, Zipcode
    FROM INDIVIDUAL as I, DONOR as D, DONATIONS as DA
    INNER JOIN I, D, DA
    ON I.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.State

    /* By Zipcode */
    SELECT Fname, Lname, City, State, Zipcode
    FROM INDIVIDUAL as I, DONOR as D, DONATIONS as DA
    INNER JOIN I, D, DA
    ON I.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.Zipcode

  /* Grouping Corporate_Organizations */
    /* By City */
    SELECT OrgName, City, State, Zipcode
    FROM CORPORATE_ORGANIZATION as CO, DONOR as D, DONATIONS as DA
    INNER JOIN CO, D, DA
    ON CO.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.City

    /* By State */
    SELECT OrgName, City, State, Zipcode
    FROM CORPORATE_ORGANIZATION as CO, DONOR as D, DONATIONS as DA
    INNER JOIN CO, D, DA
    ON CO.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.State

    /* By Zipcode */
    SELECT OrgName, City, State, Zipcode
    FROM CORPORATE_ORGANIZATION as CO, DONOR as D, DONATIONS as DA
    INNER JOIN CO, D, DA
    ON CO.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.Zipcode

  /* Group by Grant */
    /* By City */
    SELECT GrantName, City, State, Zipcode
    FROM GRANT as G, DONOR as D, DONATIONS as DA
    INNER JOIN G, D, DA
    ON G.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.City

    /* By State */
    SELECT GrantName, City, State, Zipcode
    FROM GRANT as G, DONOR as D, DONATIONS as DA
    INNER JOIN G, D, DA
    ON G.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.State

    /* By Zipcode */
    SELECT GrantName, City, State, Zipcode
    FROM GRANT as G, DONOR as D, DONATIONS as DA
    INNER JOIN G, D, DA
    ON G.DonorID = D.DonorID AND D.DonorID = DA.DonorID
    GROUP BY D.Zipcode

/* Count Donors */
SELECT Count(DonorID)
FROM DONOR
GROUP BY D.Lname

/* Calculate total amount of donations received during event */

SELECT EventName, SUM(Donations)
FROM DONATIONS as DA, EVENTS as E
INNER JOIN DA, E
ON DA.EventName = E.EventName AND DA.EventDate = E.EventDate
GROUP BY E.EventName

/* Calculate total amount of donations received during campaign */

SELECT CampaignTitle, SUM(Donations)
FROM CAMPAIGN as C, EVENTS as E, DONATIONS as DA
INNER JOIN C, E, DA
ON C.CampaignTitle = E.CampaignTitle AND E.EventName = DA.EventName AND E.EventDate = DA.EventDate
GROUP BY C.CampaignTitle

/* Grouping by Names */
  /* By Individual - Last Names*/
  SELECT *
  FROM DONOR AS D, INDIVIDUAL AS I
  INNER JOIN D, I
  ON I.DonorID = D.DonorID
  GROUP BY I.Lname

  /* By Individual - First Names */
  SELECT *
  FROM DONOR AS D, INDIVIDUAL AS I
  INNER JOIN D, I
  ON I.DonorID = D.DonorID
  GROUP BY I.Fname

  /* Corporate_Organizations */
  SELECT *
  FROM DONOR AS D, CORPORATE_ORGANIZATION AS CO
  INNER JOIN D, CO
  ON CO.DonorID = D.DonorID
  GROUP BY CO.OrgName

  /* Grant */
  SELECT *
  FROM DONOR AS D, GRANT AS G
  INNER JOIN D, G
  ON D.DonorID = D.DonorID
  GROUP BY G.GrantName

/* Updates */

UPDATE DONOR
SET
WHERE

UPDATE INDIVIDUAL
SET
WHERE

UPDATE CORPORATE_ORGANIZATION
SET
WHERE

UPDATE GRANT
SET
WHERE

UPDATE EVENTS
SET
WHERE

UPDATE CAMPAIGN
SET
WHERE

UPDATE PLEDGES
SET
WHERE

UPDATE PAYMENTTYPE
SET
WHERE

UPDATE DONATIONS
SET
WHERE

/* Insertion Statements */

  /* New Donor */
  INSERT INTO DONOR
  VALUES (Textfield1, Textfield2, Textfield3, Textfield4, Textfield5, Textfield6, Textfield7, Textfield8, Textfield9, Textfield10)

  /* New Individual */
  INSERT INTO INDIVIDUAL
  VALUES (Textfield1, Textfield2, Textfield3, Textfield4, Textfield5)

  /* New Corporate/Organization */
  INSERT INTO CORPORATE_ORGANIZATION
  VALUES (Textfield1, Textfield2)

  /* New Grants */
  INSERT INTO GRANT
  VALUES (Textfield1, Textfield2)

  /* New Events */
  INSERT INTO EVENTS
  VALUES (Textfield1, Textfield2, Textfield3, Textfield4, Textfield5)

  /* New Campaigns */
  INSERT INTO CAMPAIGN
  VALUES (Textfield1, Textfield2, Textfield3, Textfield4, Textfield5)

  /* New Donations */
  INSERT INTO DONATIONS
  VALUES (Textfield1, Textfield2, Textfield3, Textfield4, Textfield5, Textfield6, Textfield7)

  /* New Payment Type */
  INSERT INTO PAYMENTTYPE
  VALUES (Textfield1)

  /* New Pledges */
  INSERT INTO PLEDGES
  VALUES (Textfield1, Textfield2, Textfield3)

/* Deletion Statements */

  /* Deleting Full Tables */
