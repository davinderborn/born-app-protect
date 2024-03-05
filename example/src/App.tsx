import * as React from 'react';

import { StyleSheet, View, Text, Alert } from 'react-native';
import {
  enableViewSecuring,
  iOSScreenRecordingMirroring,
} from 'react-native-born-app-protect';

export default function App() {
  React.useEffect(() => {
    enableViewSecuring(true);
    iOSScreenRecordingMirroring(2)
      .then((isMirroringEnabled) => {
        console.log(
          'Screen mirroring status:',
          isMirroringEnabled ? 'enabled' : 'disabled'
        );
        if (isMirroringEnabled) {
          // Handle screen mirroring enabled
          Alert.alert(
            'Alert',
            'You might fall prey to online fraud. Please close the screen-sharing/screen-mirroring to continue using the AppSecurity App'
          );
        }
      })
      .catch((error) => console.error('Error:', error));
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
