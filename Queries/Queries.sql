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

/* Search Templates By Names */
  /* By Individual - Last Names*/
  SELECT Lname
  FROM DONOR AS D, INDIVIDUAL AS I
  INNER JOIN D, I
  ON I.DonorID = D.DonorID

  /* By Individual - First Names */
  SELECT Fname
  FROM DONOR AS D, INDIVIDUAL AS I
  INNER JOIN D, I
  ON I.DonorID = D.DonorID

  /* Corporate_Organizations */
  SELECT OrgName
  FROM DONOR AS D, CORPORATE_ORGANIZATION AS CO
  INNER JOIN D, CO
  ON CO.DonorID = D.DonorID

  /* Grant */
  SELECT GrantName
  FROM DONOR AS D, GRANT AS G
  INNER JOIN D, G
  ON D.DonorID = D.DonorID

/* Updates (SET Clause is where you put the change being made. WHERE Clause is the condition)(Not certain if an AND clause works with these statements) */
/* DONOR */
UPDATE DONOR
SET street = '', city = '', state = '', zipcode = '', phone = '', emailaddress = '', userstatus = '', solicitation = '', preferredphone = '', preferredemail = '', preferredmailaddress = '', preferredmailcity = '', preferredmailstate = '', preferredmailzipcode = ''
WHERE street = '', city = '', state = '', zipcode = '', phone = '', emailaddress = '', userstatus = '', solicitation = '', preferredphone = '', preferredemail = '', preferredmailaddress = '', preferredmailcity = '', preferredmailstate = '', preferredmailzipcode = ''

UPDATE INDIVIDUAL
SET Fname = '', Minit = '', Lname = '', PreferredHouseHoldName = '', Title = ''
WHERE Fname = '', Minit = '', Lname = '', PreferredHouseHoldName = '', Title = ''

UPDATE CORPORATE_ORGANIZATION
SET OrgName = '', PrimaryContact = ''
WHERE OrgName = '', PrimaryContact = ''

UPDATE GRANT
SET GrantName = '', StartDate = '', EndDate = '', NextReportDate = ''
WHERE GrantName = '', StartDate = '', EndDate = '', NextReportDate = ''

UPDATE EVENTS
SET EventName = '', EventDate = '', Description = '', MoneyRaised = '', CampaignTitle = ''
WHERE EventName = '', EventDate = '', Description = '', MoneyRaised = '', CampaignTitle = ''

UPDATE CAMPAIGN
SET CampaignTitle = '', StartDate = '', EndDate = '', Description = '', Goal = ''
WHERE CampaignTitle = '', StartDate = '', EndDate = '', Description = '', Goal = ''

UPDATE PLEDGES
SET Amount = '', PaymentFrequency = '', PayToDate = ''
WHERE Amount = '', PaymentFrequency = '', PayToDate = ''

UPDATE PAYMENTTYPE
SET TypeName = ''
WHERE TypeName = ''

UPDATE DONATIONS
SET DonationID = '', CampaignTitle = '', DonorID = '', Amount = '', DDate = '', Notes = '', PledgeID = '', PaymentType = '', EventName = '', EventDate = ''
WHERE DonationID = '', CampaignTitle = '', DonorID = '', Amount = '', DDate = '', Notes = '', PledgeID = '', PaymentType = '', EventName = '', EventDate = ''

/* Insertion Statements */

  /* New Donor */
  INSERT INTO DONOR
  VALUES (street, city, state, zipcode, phone, emailaddress, userstatus, solicitation, preferredphone, preferredemail, preferredmailaddress, preferredmailcity, preferredmailstate, preferredmailzipcode)

  /* New Individual */
  INSERT INTO INDIVIDUAL
  VALUES (Fname, Minit, Lname, PreferredHouseHoldName, Title)

  /* New Corporate/Organization */
  INSERT INTO CORPORATE_ORGANIZATION
  VALUES (OrgName, PrimaryContact)

  /* New Grants */
  INSERT INTO GRANT
  VALUES (GrantName, StartDate, EndDate, NextReportDate)

  /* New Events */
  INSERT INTO EVENTS
  VALUES (EventName, EventDate, Description, MoneyRaised, CampaignTitle)

  /* New Campaigns */
  INSERT INTO CAMPAIGN
  VALUES (CampaignTitle, StartDate, EndDate, Description, Goal)

  /* New Donations */
  INSERT INTO DONATIONS
  VALUES (DonationID, CampaignTitle, DonorID, Amount, DDate, Notes, PledgeID, PaymentType, EventName, EventDate)

  /* New Payment Type */
  INSERT INTO PAYMENTTYPE
  VALUES (TypeName)

  /* New Pledges */
  INSERT INTO PLEDGES
  VALUES (Amount, PaymentFrequency, PayToDate)

/* Deletion Statements */
  /* Templates */
    /* Delete Entire Records From Tables */
    DELETE FROM DONOR

    DELETE FROM INDIVIDUAL

    DELETE FROM CORPORATION_ORGANIZATION

    DELETE FROM GRANT

    DELETE FROM EVENTS

    DELETE FROM CAMPAIGN

    DELETE FROM DONATIONS

    DELETE FROM PAYMENTTYPE

    DELETE FROM PLEDGES

    /* Delete Specific Data --- Decide which AND clause to utilize */
    /* Delete from DONOR */
    DELETE FROM DONOR
    WHERE street = ''
      AND city = ''
      AND state = ''
      AND zipcode = ''
      AND phone = ''
      AND emailaddress = ''
      AND userstatus = ''
      AND solicitation = ''
      AND preferredphone = ''
      AND preferredemail = ''
      AND preferredmailaddress = ''
      AND preferredmailcity = ''
      AND preferredmailstate = ''
      AND preferredmailzipcode = ''

      /* Delete from INDIVIDUAL */
      DELETE FROM INDIVIDUAL
      WHERE Fname = ''
      AND Minit = ''
      AND Lname = ''
      AND PreferredHouseHoldName = ''
      AND Title = ''

      DELETE FROM CORPORATION_ORGANIZATION
      WHERE OrgName = ''
      AND PrimaryContact = ''

      /* DELETE from Grants */
      DELETE FROM GRANT
      WHERE GrantName = ''
      AND StartDate = ''
      AND EndDate = ''
      AND NextReportDate = ''

      /* DELETE from EVENTS */
      DELETE FROM EVENTS
      WHERE EventName = ''
      AND EventDate = ''
      AND Description = ''
      AND MoneyRaised = ''
      AND CampaignTitle = ''

      /* DELETE from CAMPAIGN */
      DELETE FROM CAMPAIGN
      WHERE CampaignTitle = ''
      AND StartDate = ''
      AND EndDate = ''
      AND Description = ''
      AND Goal = ''

      /* DELETE from DONATIONS */
      DELETE FROM DONATIONS
      WHERE DonationID = ''
      AND CampaignTitle = ''
      AND DonorID = ''
      AND Amount = ''
      AND DDate = ''
      AND Notes = ''
      AND PledgeID = ''
      AND PaymentType = ''
      AND EventName = ''
      AND EventDate = ''

      /* DELETE from PAYMENTTYPE */
      DELETE FROM PAYMENTTYPE
      WHERE TypeName = ''

      /* DELETE FROM PLEDGES */
      DELETE FROM PLEDGES
      WHERE Amount = ''
      AND PaymentFrequency = ''
      AND PayToDate = ''

/* SELECT Statements Cont. */
  /* GRANT Start & End Date */
  SELECT EndDate
  FROM GRANT AS G
  WHERE 

  SELECT StartDate
  FROM GRANT
  WHERE (clause)

  /* Solicitation Status */
  SELECT
  FROM
  WHERE
