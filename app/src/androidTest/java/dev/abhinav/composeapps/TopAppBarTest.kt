package dev.abhinav.composeapps

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import dev.abhinav.composeapps.rally.Accounts
import dev.abhinav.composeapps.rally.Bills
import dev.abhinav.composeapps.rally.Overview
import dev.abhinav.composeapps.rally.OverviewScreen
import dev.abhinav.composeapps.rally.RallyTabRow
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        val allScreens = listOf(Overview, Accounts, Bills)
        composeTestRule.setContent {
            RallyTabRow(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = Accounts
            )
        }
        composeTestRule
            .onNodeWithContentDescription(Accounts.route)
            .assertIsSelected()
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens = listOf(Overview, Accounts, Bills)
        composeTestRule.setContent {
            RallyTabRow(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = Accounts
            )
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
        composeTestRule
            .onNode(
                hasText(Accounts.route.uppercase()) and
                        hasParent(
                            hasContentDescription(Accounts.route)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }

    @Test
    fun overviewScreen_alertsDisplayed() {
        composeTestRule.setContent {
            OverviewScreen()
        }
        composeTestRule
            .onNodeWithText("Alerts")
            .assertIsDisplayed()
    }
}