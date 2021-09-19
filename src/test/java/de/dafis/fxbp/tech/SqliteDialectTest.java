package de.dafis.fxbp.tech;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("PMD.JUnitAssertionsShouldIncludeMessage")
class SqliteDialectTest
{
   // Dieser Test prüft nur die korrekte Initialisierung
   // des Dialects. Die zu testende Klasse wird von Hibernate genutzt.
   // Eine fallweise Intanziierung der Klasse verschlechtert nur die Performance.
   private static final SqliteDialect dialect = new SqliteDialect();

   @Test
   final void testSupportsLimit()
   {
      assertTrue( dialect.supportsLimit() );
   }

   @Test
   final void testSupportsOuterJoinForUpdate()
   {
      assertFalse( dialect.supportsOuterJoinForUpdate() );
   }

   @Test
   final void testSupportsCurrentTimestampSelection()
   {
      assertTrue( dialect.supportsCurrentTimestampSelection() );
   }

   @Test
   final void testIsCurrentTimestampSelectStringCallable()
   {
      assertFalse( dialect.isCurrentTimestampSelectStringCallable() );
   }

   @Test
   final void testSupportsUnionAll()
   {
      assertTrue( dialect.supportsUnionAll() );
   }

   @Test
   final void testHasAlterTable()
   {
      assertFalse( dialect.hasAlterTable() );
   }

   @Test
   final void testDropConstraints()
   {
      assertFalse( dialect.dropConstraints() );
   }

   @Test
   final void testSupportsIfExistsBeforeTableName()
   {
      assertTrue( dialect.supportsIfExistsBeforeTableName() );
   }

   @Test
   final void testSupportsCascadeDelete()
   {
      assertFalse( dialect.supportsCascadeDelete() );
   }

   @Test
   final void testSupportsIdentityColumns()
   {
      assertTrue( dialect.supportsIdentityColumns() );
   }

   @Test
   final void testHasDataTypeInIdentityColumn()
   {
      assertFalse( dialect.hasDataTypeInIdentityColumn() );
   }

   @Test
   final void testGetIdentityColumnString()
   {
      assertEquals( "integer", dialect.getIdentityColumnString() );
   }

   @Test
   final void testGetIdentitySelectString()
   {
      assertEquals( "select last_insert_rowid()", dialect.getIdentitySelectString() );
   }

   @Test
   final void testGetLimitStringWithOffset()
   {
      StringBuffer sb = new StringBuffer();
      sb.append( "select * from table" );
      String query = sb.toString();
      sb.append( " limit ? offset ?" );

      assertEquals( sb.toString(), dialect.getLimitString( query, true ) );
   }

   @Test
   final void testGetLimitStringWithoutOffset()
   {
      StringBuffer sb = new StringBuffer();
      sb.append( "select * from table" );
      String query = sb.toString();
      sb.append( " limit ?" );

      assertEquals( sb.toString(), dialect.getLimitString( query, false ) );
   }

   @Test
   final void testSupportsTemporaryTables()
   {
      assertTrue( dialect.supportsTemporaryTables() );
   }

   @Test
   final void testGetCreateTemporaryTableString()
   {
      assertEquals( "create temporary table if not exists", dialect.getCreateTemporaryTableString() );
   }

   @Test
   final void testDropTemporaryTableAfterUse()
   {
      assertFalse( dialect.dropTemporaryTableAfterUse() );
   }

   @Test
   final void testGetCurrentTimestampSelectString()
   {
      assertEquals( "select current_timestamp", dialect.getCurrentTimestampSelectString() );
   }

   @Test
   final void testGetAddColumnString()
   {
      assertEquals( "add column", dialect.getAddColumnString() );
   }

   @Test
   final void testGetForUpdateString()
   {
      assertEquals( "", dialect.getForUpdateString() );
   }

   @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
   @Test
   final void testGetDropForeignKeyString()
   {
      Exception exception = assertThrows( UnsupportedOperationException.class, () -> {
         dialect.getDropForeignKeyString();
      } );

      String expectedMessage = "No drop foreign key syntax supported by SQLiteDialect";
      String actualMessage = exception.getMessage();

      assertTrue( actualMessage.contains( expectedMessage ) );
   }

   @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
   @Test
   final void testGetAddForeignKeyConstraint()
   {
      Exception exception = assertThrows( UnsupportedOperationException.class, () -> {
         dialect.getAddForeignKeyConstraintString( "", null, "", null, false );
      } );

      String expectedMessage = "No add foreign key syntax supported by SQLiteDialect";
      String actualMessage = exception.getMessage();

      assertTrue( actualMessage.contains( expectedMessage ) );
   }

   @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
   @Test
   final void testGetAddPrimaryKeyConstraint()
   {
      Exception exception = assertThrows( UnsupportedOperationException.class, () -> {
         dialect.getAddPrimaryKeyConstraintString( "testName" );
      } );

      String expectedMessage = "No add primary key syntax supported by SQLiteDialect";
      String actualMessage = exception.getMessage();

      assertTrue( actualMessage.contains( expectedMessage ) );
   }

}
