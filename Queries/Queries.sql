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

/* Updates (SET Clause is where you put the change being made. WHERE Clause is the condition)(Not certain if AND clause works with these statements) */
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
  INSERT INTO DONOR (street, city, state, zipcode, phone, emailaddress, userstatus, solicitation, preferredphone, preferredemail, preferredmailaddress, preferredmailcity, preferredmailstate, preferredmailzipcode)
  VALUES ()

  /* New Individual */
  INSERT INTO INDIVIDUAL (Fname, Minit, Lname, PreferredHouseHoldName, Title)
  VALUES ()

  /* New Corporate/Organization */
  INSERT INTO CORPORATE_ORGANIZATION (OrgName, PrimaryContact)
  VALUES ()

  /* New Grants */
  INSERT INTO GRANT (GrantName, StartDate, EndDate, NextReportDate)
  VALUES ()

  /* New Events */
  INSERT INTO EVENTS (EventName, EventDate, Description, MoneyRaised, CampaignTitle)
  VALUES ()

  /* New Campaigns */
  INSERT INTO CAMPAIGN (CampaignTitle, StartDate, EndDate, Description, Goal)
  VALUES ()

  /* New Donations */
  INSERT INTO DONATIONS (DonationID, CampaignTitle, DonorID, Amount, DDate, Notes, PledgeID, PaymentType, EventName, EventDate)
  VALUES ()

  /* New Payment Type */
  INSERT INTO PAYMENTTYPE (TypeName)
  VALUES ()

  /* New Pledges */
  INSERT INTO PLEDGES (Amount, PaymentFrequency, PayToDate)
  VALUES ()

/* Deletion Statements */
  /* Templates */
    /* Delete Entire Records From Tables */
    DELETE FROM DONOR

    DELETE FROM INDIVIDUAL

    DELETE FROM CORPORATE_ORGANIZATION

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

      DELETE FROM CORPORATE_ORGANIZATION
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
  WHERE (clause)

  SELECT StartDate
  FROM GRANT AS G
  WHERE (clause)

  /* Donations Found Between Dates (Insert Dates) */
  SELECT DonationID
  FROM DONATIONS
  WHERE D.DDate BETWEEN DATE1 AND DATE2

  /* Get Pledge Totals */
  SELECT DonorID, PayToDate
  FROM PLEDGES AS P, DONATIONS AS DA, DONOR AS D
  INNER JOIN D, DA, P
  ON P.PledgeID = DA.PledgeID AND D.DonorID = DA.DonorID

  /* Group by Donor Status */
  -- By Individual
    SELECT Fname, Lname
    FROM INDIVIDUAL AS I, DONOR AS D
    INNER JOIN I, D
    ON I.DonorID = D.DonorID
    WHERE D.Status = "" -- Active/Inactive/Deceased
    GROUP BY I.Lname

  -- By Grant
    SELECT GrantName
    FROM GRANTS AS G, DONOR AS D
    INNER JOIN G, D
    ON G.DonorID = D.DonorID
    WHERE D.Status = "" -- Active/Inactive/Deceased
    GROUP BY G.GrantName

  -- By Corporate/Organization
    SELECT OrgName
    FROM CORPORATE_ORGANIZATION AS CO, DONOR AS D
    INNER JOIN I, G, CO, D
    ON CO.DonorID = D.DonorID
    WHERE D.Status = "" -- Active/Inactive/Deceased
    GROUP BY CO.OrgName


  /* Solicitation Status Template */
  -- By Individual
    SELECT Fname, Lname
    FROM INDIVIDUAL AS I, DONOR AS D
    INNER JOIN I, D
    ON I.DonorID = D.DonorID 
    WHERE D.Solicitation = "" -- Input Yes or No
    GROUP BY I.Lname

  -- By Grants
    SELECT GrantName
    FROM GRANTS AS G, DONOR AS D
    INNER JOIN G, D
    ON G.DonorID = D.DonorID
    WHERE D.Solicitation = "" -- Input Yes or No
    GROUP BY G.GrantName

  -- By Corporate/Organization
    SELECT DonorID
    FROM CORPORATE_ORGANIZATION AS CO, DONOR AS D
    INNER JOIN CO, D
    ON CO.DonorID = D.DonorID
    WHERE D.Solicitation = "" -- Input Yes or No
    GROUP BY CO.OrgName

  /* Donors by Payment Type */
  -- By Individual
    SELECT Fname, Lname, Amount
    FROM DONOR AS D, DONATIONS AS DA, INDIVIDUAL AS I
    INNER JOIN D, DA, I
    ON D.DonorID = DA.DonorID AND D.DonorID = I.DonorID
    GROUP BY Lname

  -- By Corporate/Organization
    SELECT OrgName Amount
    FROM DONOR AS D, DONATIONS AS DA, CORPORATE_ORGANIZATION AS CO
    INNER JOIN D, DA, CO
    ON D.DonorID = DA.DonorID AND D.DonorID = CO.DonorID
    GROUP BY CO.OrgName

  -- By Grant
    SELECT Fname, Lname, Amount
    FROM DONOR AS D, DONATIONS AS DA, GRANT AS G
    INNER JOIN D, DA, G
    ON D.DonorID = DA.DonorID AND D.DonorID = G.DonorID
    GROUP BY G.GrantName

  /* Total Donations Made During Dates */
  SELECT Count(DonationID)
  FROM DONATIONS
  WHERE D.DDate BETWEEN DATE1 AND DATE2

  /* Sum of Donations Made During Dates */
  SELECT SUM()
  FROM DONATIONS
  WHERE D.DDate BETWEEN DATE1 AND DATE2

  /* Select Using Specific Information */
    /* Email - Individual */
    SELECT EmailAddress
    FROM DONOR AS D, INDIVIDUAL AS I
    INNER JOIN D, I
    ON D.DonorID = I.DonorID
    WHERE D.EmailAddress = ""

    /* Grant */
    SELECT EmailAddress
    FROM DONOR AS D, GRANT AS G
    INNER JOIN D, I
    ON D.DonorID = G.DonorID
    WHERE D.EmailAddress = ""

    /* Corporate_Organization */
    SELECT EmailAddress
    FROM DONOR AS D, COPORATE_ORGANIZATION AS CO
    INNER JOIN D, CO
    ON D.DonorID = CO.DonorID
    WHERE D.EmailAddress = ""

    /* Preferred Email Address */
      /* Individual */
      SELECT PreferredEmail
      FROM DONOR AS D, INDIVIDUAL AS I
      INNER JOIN D, I
      ON D.DonorID = I.DonorID
      WHERE D.PreferredEmail = ""

      /* Grant */
      SELECT PreferredEmail
      FROM DONOR AS D, GRANT AS G
      INNER JOIN D, G
      ON D.DonorID = G.DonorID
      WHERE D.PreferredEmail = ""

      /* Corporate_Organization */
      SELECT PreferredEmail
      FROM DONOR AS D, CORPORATE_ORGANIZATION AS CO
      INNER JOIN D, CO
      ON D.DonorID = G.DonorID
      WHERE D.PreferredEmail = ""

    /* Phone and Preferred Phone Searches */
      /* Phone */
        /* Individual */
        SELECT Phone
        FROM DONOR AS D, INDIVIDUAL AS I
        INNER JOIN D, I
        ON D.DonorID = I.DonorID
        WHERE D.Phone = ""

        /* Grant */
        SELECT Phone
        FROM DONOR AS D, GRANT AS G
        INNER JOIN D, G
        ON D.DonorID = G.DonorID
        WHERE D.Phone = ""

        /* Corporate/Organization */
        SELECT Phone
        FROM DONOR AS D, CORPORATE_ORGANIZATION AS CO
        INNER JOIN D, CO
        ON D.DonorID = CO.DonorID
        WHERE D.Phone = ""

      /* Preferred Phone */
        /* Individual */
        SELECT PreferredPhone
        FROM DONOR AS D, INDIVIDUAL AS I
        INNER JOIN D, I
        ON D.DonorID = I.DonorID
        WHERE D.PreferredPhone = ""

        /* Grant */
        SELECT PreferredPhone
        FROM DONOR AS D, GRANT AS G
        INNER JOIN D, G
        ON D.DonorID = G.DonorID
        WHERE D.PreferredPhone = ""

        /* Corporate/Organization */
        SELECT PreferredPhone
        FROM DONOR AS D, CORPORATE_ORGANIZATION AS CO
        INNER JOIN D, CO
        ON D.DonorID = CO.DonorID
        WHERE D.PreferredPhone = ""
      
       