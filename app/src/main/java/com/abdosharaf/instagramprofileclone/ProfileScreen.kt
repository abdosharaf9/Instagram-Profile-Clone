package com.abdosharaf.instagramprofileclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Test() {
    ProfileScreen()
}

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(
            name = "abdo_sharaf9",
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)
        )
        ProfileSection()
        Spacer(modifier = Modifier.height(8.dp))
        ButtonsSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        StoriesHighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.image_1),
                    title = "Story Highlight 1"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.image_2),
                    title = "Story Highlight 2"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.image_3),
                    title = "Story Highlight 3"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.image_4),
                    title = "Story Highlight 4"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.image_1),
                    title = "Story Highlight 5"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.image_2),
                    title = "Story Highlight 6"
                )
            ),
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TabsSection(tabs = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.ic_grid),
                title = "Grid"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_reels),
                title = "Reels"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_igtv),
                title = "IGTV"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.profile),
                title = "Profile"
            )
        ), onTabSelected = {
            selectedTabIndex = it
        })

        when (selectedTabIndex) {
            0 -> PostsSection(
                posts = listOf(
                    painterResource(id = R.drawable.abdo_profile_image),
                    painterResource(id = R.drawable.image_1),
                    painterResource(id = R.drawable.image_2),
                    painterResource(id = R.drawable.image_3),
                    painterResource(id = R.drawable.image_4),
                    painterResource(id = R.drawable.abdo_profile_image),
                    painterResource(id = R.drawable.image_1),
                    painterResource(id = R.drawable.image_2),
                    painterResource(id = R.drawable.image_3),
                    painterResource(id = R.drawable.image_4)
                )
            )
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )

        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .weight(7f)
                .padding(start = 14.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notifications",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
                .weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier
                .size(18.dp)
                .weight(1f)
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = contentDescription,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ProfileStat(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = content,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = title,
            color = Color.Black
        )
    }
}

@Composable
fun StatsSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileStat(
            title = "Posts",
            content = "105",
            modifier = Modifier.weight(1f)
        )
        ProfileStat(
            title = "Followers",
            content = "529",
            modifier = Modifier.weight(1f)
        )
        ProfileStat(
            title = "Following",
            content = "595",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun DescriptionSection(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    othersCount: Int,
    modifier: Modifier = Modifier
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = displayName,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = description,
            color = Color.Black,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)

                    append("followed by ")
                    followedBy.forEachIndexed { index, username ->
                        pushStyle(boldStyle)
                        append(username)
                        pop()
                        if (index != followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (othersCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$othersCount others")
                    }
                },
                color = Color.Black,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.abdo_profile_image),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )

            Spacer(modifier = modifier.width(16.dp))

            StatsSection(modifier = Modifier.weight(7f))
        }

        DescriptionSection(
            displayName = "\uD835\uDD38\uD835\uDD53\uD835\uDD55\uD835\uDD60 \uD835\uDD4A\uD835\uDD59\uD835\uDD52\uD835\uDD63\uD835\uDD52\uD835\uDD57",
            description = "CS student \uD83D\uDDA5\uFE0F\n" +
                    "Junior Android developer \uD83D\uDCF1",
            url = "https://www.github.com/abdosharaf9",
            followedBy = listOf("ziadwael_22", "ziad_helaly"),
            othersCount = 13
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,
    contentDescription: String? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun ButtonsSection(modifier: Modifier = Modifier) {
    val minWidth = 85.dp
    val height = 30.dp
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ActionButton(
            text = "Following",
            contentDescription = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
                .defaultMinSize(minWidth = minWidth)
        )

        ActionButton(
            text = "Message",
            modifier = Modifier
                .height(height)
                .defaultMinSize(minWidth = minWidth)
        )

        ActionButton(
            text = "Email",
            modifier = Modifier
                .height(height)
                .defaultMinSize(minWidth = minWidth)
        )

        ActionButton(
            contentDescription = "More",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.size(height)
        )
    }
}

@Composable
fun StoriesHighlightSection(
    highlights: List<ImageWithText>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .width(70.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    contentDescription = highlights[it].title,
                    modifier = Modifier.size(70.dp)
                )

                Text(
                    text = highlights[it].title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun TabsSection(
    tabs: List<ImageWithText>,
    onTabSelected: (selectedTabIndex: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = Color.Black
                )
            }
        }
    ) {
        tabs.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.title,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostsSection(posts: List<Painter>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier/*.scale(1.01f)*/
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 0.5.dp, color = Color.White)
            )
        }
    }
}