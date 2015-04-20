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
WHERE

/* Count and group donors by Type */

SELECT
FROM
WHERE
GROUP BY

/* Calculate total amount of donations received during event */

SELECT EventName, SUM(Donations)
FROM DONATIONS as DA, EVENTS as E
WHERE DA.EventName = E.EventName AND DA.EventDate = E.EventDate;

/* Calculate total amount of donations received during campaign (WIP) */

SELECT CampaignTitle, SUM(Donations)
FROM CAMPAIGN as C, EVENTS as E, DONATIONS as DA
WHERE C.CampaignTitle = EVENTS.CampaignTitle AND E.EventName = DA.EventName AND E.EventDate = DA.EventDate;

/* Updates */

UPDATE DONOR
SET
WHERE

/* Insertion Statements */

/* New Donors */
INSERT INTO DONOR
VALUES

/* New Individuals */
INSERT INTO INDIVIDUAL
VALUES

/* New Corporate/Organizations */
INSERT INTO CORPORATE/ORGANIZATIONS
VALUES

/* New Grants */
INSERT INTO GRANTS
VALUES

/* New Events */

/* New Campaigns */

/* Deletion Statements
