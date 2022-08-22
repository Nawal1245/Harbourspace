package com.example.harbourspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LayoutContainer()

        }
    }


    @Composable
    fun LayoutContainer(){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)) {

            Image(painter = painterResource(id = R.drawable.camden),
                contentDescription = stringResource(id = R.string.image_description))
            Column {
                Row(Modifier.height(height = 100.dp)) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.avatar),
                            contentDescription = stringResource(id = R.string.image_description),
                            Modifier.size(50.dp)
                        )

                        Column {
                        Text(
                            text = stringResource(id = R.string.Person_name), color = (Color.White),
                            modifier = Modifier.padding(horizontal = 50.dp)
                        )
                    }

                    }

                    Column {
                        Row {
                            Button(onClick = {}, modifier = Modifier.size(60.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                                Image(
                                    painter = painterResource(id = R.drawable.download1),
                                    contentDescription = stringResource(
                                        id = R.string.image_description
                                    )
                                )
                            }


                            Button(onClick = {}, modifier = Modifier.size(60.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                                Image(
                                    painter = painterResource(id = R.drawable.like),
                                    contentDescription = stringResource(
                                        id = R.string.image_description
                                    )
                                )


                            }
                            Button(onClick = {}, modifier = Modifier.size(60.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                                Image(
                                    painter = painterResource(id = R.drawable.share),
                                    contentDescription = stringResource(
                                        id = R.string.image_description
                                    )
                                )


                            }
                        }

                    }

                }

            }

            Row(Modifier.height(height = 100.dp)){

                Column(Modifier.width(width = 250.dp)) {
                    Text(text = stringResource(id = R.string.Camera), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontWeight = FontWeight.Bold )
                    Text(text = stringResource(id = R.string.Camera_N), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 20.dp) )
                }
                Column{

                    Text(text = stringResource(id = R.string.Aperture), color = (Color.White),
                        fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.Aperture_N), color = (Color.White))
                }




            }


            Row(Modifier.height(height = 100.dp)){

                Column(Modifier.width(width = 250.dp)) {
                    Text(text = stringResource(id = R.string.Focal_length), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.Focal_length_N), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 20.dp) )
                }
                Column{

                    Text(text = stringResource(id = R.string.Shutter_speed), color = (Color.White),
                        fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.Shutter_speed_N), color = (Color.White))
                }


            }


            Row(Modifier.height(height = 100.dp)){

                Column(Modifier.width(width = 250.dp)) {
                    Text(text = stringResource(id = R.string.ISO), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.ISO_N), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 20.dp))
                }
                Column{

                    Text(text = stringResource(id = R.string.Dimensions), color = (Color.White),
                        fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.Dimensions_N), color = (Color.White))
                }


            }

            Row(Modifier.height(height = 100.dp)){

                Column(Modifier.width(width = 100.dp)) {
                    Text(text = stringResource(id = R.string.Views), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 30.dp))
                    Text(text = stringResource(id = R.string.Views_N), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 30.dp) )
                }
                Column{

                    Text(text = stringResource(id = R.string.Downloads), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 30.dp))
                    Text(text = stringResource(id = R.string.Downloads_N), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 30.dp))
                }

                Column{
                    Text(text = stringResource(id = R.string.Likes), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 30.dp))
                    Text(text = stringResource(id = R.string.Likes_N), color = (Color.White),
                        modifier = Modifier.padding(horizontal = 30.dp))
                }


            }


            Row(Modifier.height(height = 100.dp)){

                Column{
                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)) {
                        Text("Camden Market")

                    }


                }
                Column{

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)) {
                        Text("UK")

                    }
                }


            }



        }

        Row(modifier = Modifier.padding(top = 145.dp)) {

            Image(
                painter = painterResource(id = R.drawable.preview),
                contentDescription = stringResource(id = R.string.image_description),
                Modifier.size(20.dp))


            Text(
                text = stringResource(id = R.string.image_description), color = (Color.White),
                modifier = Modifier.padding(horizontal = 10.dp))

        }

    }


}





@Preview
@Composable
fun LayoutContainer () {
    LayoutContainer ()
}
